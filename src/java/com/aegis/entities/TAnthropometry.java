/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "t_anthropometry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TAnthropometry.findAll", query = "SELECT t FROM TAnthropometry t")
    , @NamedQuery(name = "TAnthropometry.findById", query = "SELECT t FROM TAnthropometry t WHERE t.id = :id")
    , @NamedQuery(name = "TAnthropometry.findByWeight", query = "SELECT t FROM TAnthropometry t WHERE t.weight = :weight")
    , @NamedQuery(name = "TAnthropometry.findByWeightDeviation", query = "SELECT t FROM TAnthropometry t WHERE t.weightDeviation = :weightDeviation")
    , @NamedQuery(name = "TAnthropometry.findByHeight", query = "SELECT t FROM TAnthropometry t WHERE t.height = :height")
    , @NamedQuery(name = "TAnthropometry.findByHeightDeviation", query = "SELECT t FROM TAnthropometry t WHERE t.heightDeviation = :heightDeviation")
    , @NamedQuery(name = "TAnthropometry.findByWeightforHeightLenghtDeviation", query = "SELECT t FROM TAnthropometry t WHERE t.weightforHeightLenghtDeviation = :weightforHeightLenghtDeviation")
    , @NamedQuery(name = "TAnthropometry.findByHeadCircumferenceValue", query = "SELECT t FROM TAnthropometry t WHERE t.headCircumferenceValue = :headCircumferenceValue")
    , @NamedQuery(name = "TAnthropometry.findByHeadCircumferenceDeviation", query = "SELECT t FROM TAnthropometry t WHERE t.headCircumferenceDeviation = :headCircumferenceDeviation")
    , @NamedQuery(name = "TAnthropometry.findByHeadCircumferenceClassification", query = "SELECT t FROM TAnthropometry t WHERE t.headCircumferenceClassification = :headCircumferenceClassification")
    , @NamedQuery(name = "TAnthropometry.findByMUACValue", query = "SELECT t FROM TAnthropometry t WHERE t.mUACValue = :mUACValue")
    , @NamedQuery(name = "TAnthropometry.findByMUACClassification", query = "SELECT t FROM TAnthropometry t WHERE t.mUACClassification = :mUACClassification")
    , @NamedQuery(name = "TAnthropometry.findByBMIValue", query = "SELECT t FROM TAnthropometry t WHERE t.bMIValue = :bMIValue")
    , @NamedQuery(name = "TAnthropometry.findByBMIClassification", query = "SELECT t FROM TAnthropometry t WHERE t.bMIClassification = :bMIClassification")
    , @NamedQuery(name = "TAnthropometry.findByBPValue", query = "SELECT t FROM TAnthropometry t WHERE t.bPValue = :bPValue")
    , @NamedQuery(name = "TAnthropometry.findByBPClassification", query = "SELECT t FROM TAnthropometry t WHERE t.bPClassification = :bPClassification")
    , @NamedQuery(name = "TAnthropometry.findByVisionLeftEye", query = "SELECT t FROM TAnthropometry t WHERE t.visionLeftEye = :visionLeftEye")
    , @NamedQuery(name = "TAnthropometry.findByVisionRightEye", query = "SELECT t FROM TAnthropometry t WHERE t.visionRightEye = :visionRightEye")
    , @NamedQuery(name = "TAnthropometry.findByAvailableID", query = "SELECT t FROM TAnthropometry t WHERE t.availableID = :availableID")
    , @NamedQuery(name = "TAnthropometry.findByRemarks", query = "SELECT t FROM TAnthropometry t WHERE t.remarks = :remarks")
    , @NamedQuery(name = "TAnthropometry.findByCreatedDate", query = "SELECT t FROM TAnthropometry t WHERE t.createdDate = :createdDate")
    , @NamedQuery(name = "TAnthropometry.findByCreatedUserId", query = "SELECT t FROM TAnthropometry t WHERE t.createdUserId = :createdUserId")})
public class TAnthropometry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Weight")
    private BigDecimal weight;
    @Column(name = "WeightDeviation")
    private String weightDeviation;
    @Column(name = "Height")
    private BigDecimal height;
    @Column(name = "HeightDeviation")
    private String heightDeviation;
    @Column(name = "WeightforHeightLenghtDeviation")
    private String weightforHeightLenghtDeviation;
    @Column(name = "HeadCircumferenceValue")
    private String headCircumferenceValue;
    @Column(name = "HeadCircumferenceDeviation")
    private String headCircumferenceDeviation;
    @Column(name = "HeadCircumferenceClassification")
    private String headCircumferenceClassification;
    @Column(name = "MUACValue")
    private String mUACValue;
    @Column(name = "MUACClassification")
    private String mUACClassification;
    @Column(name = "BMIValue")
    private BigDecimal bMIValue;
    @Column(name = "BMIClassification")
    private String bMIClassification;
    @Column(name = "BPValue")
    private String bPValue;
    @Column(name = "BPClassification")
    private String bPClassification;
    @Column(name = "VisionLeftEye")
    private BigDecimal visionLeftEye;
    @Column(name = "VisionRightEye")
    private BigDecimal visionRightEye;
    @Column(name = "AvailableID")
    private Integer availableID;
    @Column(name = "Remarks")
    private String remarks;
    @Basic(optional = false)
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "CreatedUserId")
    private int createdUserId;
    @JoinColumn(name = "ChildId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MChild childId;
    @JoinColumn(name = "TeamId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MTeam teamId;

    public TAnthropometry() {
    }

    public TAnthropometry(Integer id) {
        this.id = id;
    }

    public TAnthropometry(Integer id, Date createdDate, int createdUserId) {
        this.id = id;
        this.createdDate = createdDate;
        this.createdUserId = createdUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightDeviation() {
        return weightDeviation;
    }

    public void setWeightDeviation(String weightDeviation) {
        this.weightDeviation = weightDeviation;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getHeightDeviation() {
        return heightDeviation;
    }

    public void setHeightDeviation(String heightDeviation) {
        this.heightDeviation = heightDeviation;
    }

    public String getWeightforHeightLenghtDeviation() {
        return weightforHeightLenghtDeviation;
    }

    public void setWeightforHeightLenghtDeviation(String weightforHeightLenghtDeviation) {
        this.weightforHeightLenghtDeviation = weightforHeightLenghtDeviation;
    }

    public String getHeadCircumferenceValue() {
        return headCircumferenceValue;
    }

    public void setHeadCircumferenceValue(String headCircumferenceValue) {
        this.headCircumferenceValue = headCircumferenceValue;
    }

    public String getHeadCircumferenceDeviation() {
        return headCircumferenceDeviation;
    }

    public void setHeadCircumferenceDeviation(String headCircumferenceDeviation) {
        this.headCircumferenceDeviation = headCircumferenceDeviation;
    }

    public String getHeadCircumferenceClassification() {
        return headCircumferenceClassification;
    }

    public void setHeadCircumferenceClassification(String headCircumferenceClassification) {
        this.headCircumferenceClassification = headCircumferenceClassification;
    }

    public String getMUACValue() {
        return mUACValue;
    }

    public void setMUACValue(String mUACValue) {
        this.mUACValue = mUACValue;
    }

    public String getMUACClassification() {
        return mUACClassification;
    }

    public void setMUACClassification(String mUACClassification) {
        this.mUACClassification = mUACClassification;
    }

    public BigDecimal getBMIValue() {
        return bMIValue;
    }

    public void setBMIValue(BigDecimal bMIValue) {
        this.bMIValue = bMIValue;
    }

    public String getBMIClassification() {
        return bMIClassification;
    }

    public void setBMIClassification(String bMIClassification) {
        this.bMIClassification = bMIClassification;
    }

    public String getBPValue() {
        return bPValue;
    }

    public void setBPValue(String bPValue) {
        this.bPValue = bPValue;
    }

    public String getBPClassification() {
        return bPClassification;
    }

    public void setBPClassification(String bPClassification) {
        this.bPClassification = bPClassification;
    }

    public BigDecimal getVisionLeftEye() {
        return visionLeftEye;
    }

    public void setVisionLeftEye(BigDecimal visionLeftEye) {
        this.visionLeftEye = visionLeftEye;
    }

    public BigDecimal getVisionRightEye() {
        return visionRightEye;
    }

    public void setVisionRightEye(BigDecimal visionRightEye) {
        this.visionRightEye = visionRightEye;
    }

    public Integer getAvailableID() {
        return availableID;
    }

    public void setAvailableID(Integer availableID) {
        this.availableID = availableID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(int createdUserId) {
        this.createdUserId = createdUserId;
    }

    public MChild getChildId() {
        return childId;
    }

    public void setChildId(MChild childId) {
        this.childId = childId;
    }

    public MTeam getTeamId() {
        return teamId;
    }

    public void setTeamId(MTeam teamId) {
        this.teamId = teamId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAnthropometry)) {
            return false;
        }
        TAnthropometry other = (TAnthropometry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TAnthropometry[ id=" + id + " ]";
    }
    
}
