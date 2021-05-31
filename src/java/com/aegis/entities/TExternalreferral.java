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
@Table(name = "t_Externalreferral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TExternalreferral.findAll", query = "SELECT t FROM TExternalreferral t")
    , @NamedQuery(name = "TExternalreferral.findById", query = "SELECT t FROM TExternalreferral t WHERE t.id = :id")
    , @NamedQuery(name = "TExternalreferral.findByTranfindingId", query = "SELECT t FROM TExternalreferral t WHERE t.tranfindingId = :tranfindingId")
    , @NamedQuery(name = "TExternalreferral.findByProcedureId", query = "SELECT t FROM TExternalreferral t WHERE t.procedureId = :procedureId")
    , @NamedQuery(name = "TExternalreferral.findByReferredHospitalId", query = "SELECT t FROM TExternalreferral t WHERE t.referredHospitalId = :referredHospitalId")
    , @NamedQuery(name = "TExternalreferral.findByRemarks", query = "SELECT t FROM TExternalreferral t WHERE t.remarks = :remarks")
    , @NamedQuery(name = "TExternalreferral.findByHasMedical", query = "SELECT t FROM TExternalreferral t WHERE t.hasMedical = :hasMedical")
    , @NamedQuery(name = "TExternalreferral.findByIsActive", query = "SELECT t FROM TExternalreferral t WHERE t.isActive = :isActive")
    , @NamedQuery(name = "TExternalreferral.findByCreatedUserId", query = "SELECT t FROM TExternalreferral t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TExternalreferral.findByCreatedDate", query = "SELECT t FROM TExternalreferral t WHERE t.createdDate = :createdDate")})
public class TExternalreferral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TranfindingId")
    private int tranfindingId;
    @Column(name = "ProcedureId")
    private Integer procedureId;
    @Column(name = "ReferredHospitalId")
    private Integer referredHospitalId;
    @Column(name = "Remarks")
    private String remarks;
    @Basic(optional = false)
    @Column(name = "HasMedical")
    private boolean hasMedical;
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

    public TExternalreferral() {
    }

    public TExternalreferral(Integer id) {
        this.id = id;
    }

    public TExternalreferral(Integer id, int tranfindingId, boolean hasMedical, boolean isActive, int createdUserId, Date createdDate) {
        this.id = id;
        this.tranfindingId = tranfindingId;
        this.hasMedical = hasMedical;
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

    public int getTranfindingId() {
        return tranfindingId;
    }

    public void setTranfindingId(int tranfindingId) {
        this.tranfindingId = tranfindingId;
    }

    public Integer getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }

    public Integer getReferredHospitalId() {
        return referredHospitalId;
    }

    public void setReferredHospitalId(Integer referredHospitalId) {
        this.referredHospitalId = referredHospitalId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean getHasMedical() {
        return hasMedical;
    }

    public void setHasMedical(boolean hasMedical) {
        this.hasMedical = hasMedical;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TExternalreferral)) {
            return false;
        }
        TExternalreferral other = (TExternalreferral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TExternalreferral[ id=" + id + " ]";
    }
    
}
