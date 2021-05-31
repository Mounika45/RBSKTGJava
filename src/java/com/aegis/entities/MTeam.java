/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "m_team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MTeam.findAll", query = "SELECT m FROM MTeam m")
    , @NamedQuery(name = "MTeam.findById", query = "SELECT m FROM MTeam m WHERE m.id = :id")
    , @NamedQuery(name = "MTeam.findByCode", query = "SELECT m FROM MTeam m WHERE m.code = :code")
    , @NamedQuery(name = "MTeam.findByManualCode", query = "SELECT m FROM MTeam m WHERE m.manualCode = :manualCode")
    , @NamedQuery(name = "MTeam.findByDistrictId", query = "SELECT m FROM MTeam m WHERE m.districtId = :districtId")
    , @NamedQuery(name = "MTeam.findByMandalId", query = "SELECT m FROM MTeam m WHERE m.mandalId = :mandalId")
    , @NamedQuery(name = "MTeam.findByReportPHCId", query = "SELECT m FROM MTeam m WHERE m.reportPHCId = :reportPHCId")
    , @NamedQuery(name = "MTeam.findByAssociatedPHCId", query = "SELECT m FROM MTeam m WHERE m.associatedPHCId = :associatedPHCId")
    , @NamedQuery(name = "MTeam.findByIMEINumber", query = "SELECT m FROM MTeam m WHERE m.iMEINumber = :iMEINumber")
    , @NamedQuery(name = "MTeam.findByEmailID", query = "SELECT m FROM MTeam m WHERE m.emailID = :emailID")
    , @NamedQuery(name = "MTeam.findByIsActive", query = "SELECT m FROM MTeam m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MTeam.findByCreatedUserId", query = "SELECT m FROM MTeam m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MTeam.findByCreatedDate", query = "SELECT m FROM MTeam m WHERE m.createdDate = :createdDate")})
public class MTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @Column(name = "ManualCode")
    private String manualCode;
    @Basic(optional = false)
    @Column(name = "DistrictId")
    private int districtId;
    @Basic(optional = false)
    @Column(name = "MandalId")
    private String mandalId;
    @Basic(optional = false)
    @Column(name = "ReportPHCId")
    private int reportPHCId;
    @Basic(optional = false)
    @Column(name = "AssociatedPHCId")
    private String associatedPHCId;
    @Column(name = "IMEINumber")
    private String iMEINumber;
    @Column(name = "EmailID")
    private String emailID;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "CreatedUserId")
    private int createdUserId;
    @Basic(optional = false)
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "mTeam1")
    private MTeam mTeam;
    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MTeam mTeam1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamId")
    private Collection<MTeammember> mTeammemberCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamId")
    private Collection<TAnthropometry> tAnthropometryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdTeamId")
    private Collection<TScreentimelog> tScreentimelogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamId")
    private Collection<TTeamschedule> tTeamscheduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdTeamId")
    private Collection<TSchoolquestionanswer> tSchoolquestionanswerCollection;

    public MTeam() {
    }

    public MTeam(Integer id) {
        this.id = id;
    }

    public MTeam(Integer id, String code, String manualCode, int districtId, String mandalId, int reportPHCId, String associatedPHCId, boolean isActive, int createdUserId, Date createdDate) {
        this.id = id;
        this.code = code;
        this.manualCode = manualCode;
        this.districtId = districtId;
        this.mandalId = mandalId;
        this.reportPHCId = reportPHCId;
        this.associatedPHCId = associatedPHCId;
        this.isActive = isActive;
        this.createdUserId = createdUserId;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getManualCode() {
        return manualCode;
    }

    public void setManualCode(String manualCode) {
        this.manualCode = manualCode;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getMandalId() {
        return mandalId;
    }

    public void setMandalId(String mandalId) {
        this.mandalId = mandalId;
    }

    public int getReportPHCId() {
        return reportPHCId;
    }

    public void setReportPHCId(int reportPHCId) {
        this.reportPHCId = reportPHCId;
    }

    public String getAssociatedPHCId() {
        return associatedPHCId;
    }

    public void setAssociatedPHCId(String associatedPHCId) {
        this.associatedPHCId = associatedPHCId;
    }

    public String getIMEINumber() {
        return iMEINumber;
    }

    public void setIMEINumber(String iMEINumber) {
        this.iMEINumber = iMEINumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(int createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public MTeam getMTeam() {
        return mTeam;
    }

    public void setMTeam(MTeam mTeam) {
        this.mTeam = mTeam;
    }

    public MTeam getMTeam1() {
        return mTeam1;
    }

    public void setMTeam1(MTeam mTeam1) {
        this.mTeam1 = mTeam1;
    }

    @XmlTransient
    public Collection<MTeammember> getMTeammemberCollection() {
        return mTeammemberCollection;
    }

    public void setMTeammemberCollection(Collection<MTeammember> mTeammemberCollection) {
        this.mTeammemberCollection = mTeammemberCollection;
    }

    @XmlTransient
    public Collection<TAnthropometry> getTAnthropometryCollection() {
        return tAnthropometryCollection;
    }

    public void setTAnthropometryCollection(Collection<TAnthropometry> tAnthropometryCollection) {
        this.tAnthropometryCollection = tAnthropometryCollection;
    }

    @XmlTransient
    public Collection<TScreentimelog> getTScreentimelogCollection() {
        return tScreentimelogCollection;
    }

    public void setTScreentimelogCollection(Collection<TScreentimelog> tScreentimelogCollection) {
        this.tScreentimelogCollection = tScreentimelogCollection;
    }

    @XmlTransient
    public Collection<TTeamschedule> getTTeamscheduleCollection() {
        return tTeamscheduleCollection;
    }

    public void setTTeamscheduleCollection(Collection<TTeamschedule> tTeamscheduleCollection) {
        this.tTeamscheduleCollection = tTeamscheduleCollection;
    }

    @XmlTransient
    public Collection<TSchoolquestionanswer> getTSchoolquestionanswerCollection() {
        return tSchoolquestionanswerCollection;
    }

    public void setTSchoolquestionanswerCollection(Collection<TSchoolquestionanswer> tSchoolquestionanswerCollection) {
        this.tSchoolquestionanswerCollection = tSchoolquestionanswerCollection;
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
        if (!(object instanceof MTeam)) {
            return false;
        }
        MTeam other = (MTeam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MTeam[ id=" + id + " ]";
    }
    
}
