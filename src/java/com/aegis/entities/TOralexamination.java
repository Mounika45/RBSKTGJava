/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "t_oralexamination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TOralexamination.findAll", query = "SELECT t FROM TOralexamination t")
    , @NamedQuery(name = "TOralexamination.findById", query = "SELECT t FROM TOralexamination t WHERE t.id = :id")
    , @NamedQuery(name = "TOralexamination.findByTranFindingId", query = "SELECT t FROM TOralexamination t WHERE t.tranFindingId = :tranFindingId")
    , @NamedQuery(name = "TOralexamination.findByOralExaminatonType", query = "SELECT t FROM TOralexamination t WHERE t.oralExaminatonType = :oralExaminatonType")
    , @NamedQuery(name = "TOralexamination.findByPastDentalHistory", query = "SELECT t FROM TOralexamination t WHERE t.pastDentalHistory = :pastDentalHistory")
    , @NamedQuery(name = "TOralexamination.findByHasSoftTissue", query = "SELECT t FROM TOralexamination t WHERE t.hasSoftTissue = :hasSoftTissue")
    , @NamedQuery(name = "TOralexamination.findBySoftTissueRemarks", query = "SELECT t FROM TOralexamination t WHERE t.softTissueRemarks = :softTissueRemarks")
    , @NamedQuery(name = "TOralexamination.findByHasHardTissue", query = "SELECT t FROM TOralexamination t WHERE t.hasHardTissue = :hasHardTissue")
    , @NamedQuery(name = "TOralexamination.findByHardTissueRemarks", query = "SELECT t FROM TOralexamination t WHERE t.hardTissueRemarks = :hardTissueRemarks")
    , @NamedQuery(name = "TOralexamination.findByCreatedUserId", query = "SELECT t FROM TOralexamination t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TOralexamination.findByCreatedOn", query = "SELECT t FROM TOralexamination t WHERE t.createdOn = :createdOn")})
public class TOralexamination implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "TranFindingId")
    private Integer tranFindingId;
    @Column(name = "OralExaminatonType")
    private String oralExaminatonType;
    @Column(name = "PastDentalHistory")
    private String pastDentalHistory;
    @Column(name = "HasSoftTissue")
    private Boolean hasSoftTissue;
    @Column(name = "SoftTissueRemarks")
    private String softTissueRemarks;
    @Column(name = "HasHardTissue")
    private Boolean hasHardTissue;
    @Column(name = "HardTissueRemarks")
    private String hardTissueRemarks;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TOralexamination() {
    }

    public TOralexamination(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTranFindingId() {
        return tranFindingId;
    }

    public void setTranFindingId(Integer tranFindingId) {
        this.tranFindingId = tranFindingId;
    }

    public String getOralExaminatonType() {
        return oralExaminatonType;
    }

    public void setOralExaminatonType(String oralExaminatonType) {
        this.oralExaminatonType = oralExaminatonType;
    }

    public String getPastDentalHistory() {
        return pastDentalHistory;
    }

    public void setPastDentalHistory(String pastDentalHistory) {
        this.pastDentalHistory = pastDentalHistory;
    }

    public Boolean getHasSoftTissue() {
        return hasSoftTissue;
    }

    public void setHasSoftTissue(Boolean hasSoftTissue) {
        this.hasSoftTissue = hasSoftTissue;
    }

    public String getSoftTissueRemarks() {
        return softTissueRemarks;
    }

    public void setSoftTissueRemarks(String softTissueRemarks) {
        this.softTissueRemarks = softTissueRemarks;
    }

    public Boolean getHasHardTissue() {
        return hasHardTissue;
    }

    public void setHasHardTissue(Boolean hasHardTissue) {
        this.hasHardTissue = hasHardTissue;
    }

    public String getHardTissueRemarks() {
        return hardTissueRemarks;
    }

    public void setHardTissueRemarks(String hardTissueRemarks) {
        this.hardTissueRemarks = hardTissueRemarks;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
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
        if (!(object instanceof TOralexamination)) {
            return false;
        }
        TOralexamination other = (TOralexamination) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TOralexamination[ id=" + id + " ]";
    }
    
}
