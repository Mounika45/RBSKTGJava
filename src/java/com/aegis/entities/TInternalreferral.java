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
@Table(name = "t_internalreferral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TInternalreferral.findAll", query = "SELECT t FROM TInternalreferral t")
    , @NamedQuery(name = "TInternalreferral.findById", query = "SELECT t FROM TInternalreferral t WHERE t.id = :id")
    , @NamedQuery(name = "TInternalreferral.findByTranfindingId", query = "SELECT t FROM TInternalreferral t WHERE t.tranfindingId = :tranfindingId")
    , @NamedQuery(name = "TInternalreferral.findBySpecilizationId", query = "SELECT t FROM TInternalreferral t WHERE t.specilizationId = :specilizationId")
    , @NamedQuery(name = "TInternalreferral.findByRemarks", query = "SELECT t FROM TInternalreferral t WHERE t.remarks = :remarks")
    , @NamedQuery(name = "TInternalreferral.findByHasMedical", query = "SELECT t FROM TInternalreferral t WHERE t.hasMedical = :hasMedical")
    , @NamedQuery(name = "TInternalreferral.findByIsDoctorNotAvailable", query = "SELECT t FROM TInternalreferral t WHERE t.isDoctorNotAvailable = :isDoctorNotAvailable")
    , @NamedQuery(name = "TInternalreferral.findByCreatedUserId", query = "SELECT t FROM TInternalreferral t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TInternalreferral.findByCreatedDate", query = "SELECT t FROM TInternalreferral t WHERE t.createdDate = :createdDate")})
public class TInternalreferral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TranfindingId")
    private int tranfindingId;
    @Basic(optional = false)
    @Column(name = "SpecilizationId")
    private int specilizationId;
    @Basic(optional = false)
    @Column(name = "Remarks")
    private String remarks;
    @Basic(optional = false)
    @Column(name = "HasMedical")
    private boolean hasMedical;
    @Basic(optional = false)
    @Column(name = "IsDoctorNotAvailable")
    private boolean isDoctorNotAvailable;
    @Basic(optional = false)
    @Column(name = "CreatedUserId")
    private int createdUserId;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public TInternalreferral() {
    }

    public TInternalreferral(Integer id) {
        this.id = id;
    }

    public TInternalreferral(Integer id, int tranfindingId, int specilizationId, String remarks, boolean hasMedical, boolean isDoctorNotAvailable, int createdUserId) {
        this.id = id;
        this.tranfindingId = tranfindingId;
        this.specilizationId = specilizationId;
        this.remarks = remarks;
        this.hasMedical = hasMedical;
        this.isDoctorNotAvailable = isDoctorNotAvailable;
        this.createdUserId = createdUserId;
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

    public int getSpecilizationId() {
        return specilizationId;
    }

    public void setSpecilizationId(int specilizationId) {
        this.specilizationId = specilizationId;
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

    public boolean getIsDoctorNotAvailable() {
        return isDoctorNotAvailable;
    }

    public void setIsDoctorNotAvailable(boolean isDoctorNotAvailable) {
        this.isDoctorNotAvailable = isDoctorNotAvailable;
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
        if (!(object instanceof TInternalreferral)) {
            return false;
        }
        TInternalreferral other = (TInternalreferral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TInternalreferral[ id=" + id + " ]";
    }
    
}
