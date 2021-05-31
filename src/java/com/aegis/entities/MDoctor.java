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
@Table(name = "m_doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MDoctor.findAll", query = "SELECT m FROM MDoctor m")
    , @NamedQuery(name = "MDoctor.findById", query = "SELECT m FROM MDoctor m WHERE m.id = :id")
    , @NamedQuery(name = "MDoctor.findByName", query = "SELECT m FROM MDoctor m WHERE m.name = :name")
    , @NamedQuery(name = "MDoctor.findByMobileNumber", query = "SELECT m FROM MDoctor m WHERE m.mobileNumber = :mobileNumber")
    , @NamedQuery(name = "MDoctor.findBySpecializationId", query = "SELECT m FROM MDoctor m WHERE m.specializationId = :specializationId")
    , @NamedQuery(name = "MDoctor.findByJoinedDate", query = "SELECT m FROM MDoctor m WHERE m.joinedDate = :joinedDate")
    , @NamedQuery(name = "MDoctor.findByRelievingDate", query = "SELECT m FROM MDoctor m WHERE m.relievingDate = :relievingDate")
    , @NamedQuery(name = "MDoctor.findByIsActive", query = "SELECT m FROM MDoctor m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MDoctor.findByCreatedUserId", query = "SELECT m FROM MDoctor m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MDoctor.findByCreatedOn", query = "SELECT m FROM MDoctor m WHERE m.createdOn = :createdOn")
    , @NamedQuery(name = "MDoctor.findByUpdatedUserId", query = "SELECT m FROM MDoctor m WHERE m.updatedUserId = :updatedUserId")
    , @NamedQuery(name = "MDoctor.findByUpdatedOn", query = "SELECT m FROM MDoctor m WHERE m.updatedOn = :updatedOn")})
public class MDoctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "MobileNumber")
    private String mobileNumber;
    @Basic(optional = false)
    @Column(name = "SpecializationId")
    private int specializationId;
    @Column(name = "JoinedDate")
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    @Column(name = "RelievingDate")
    @Temporal(TemporalType.DATE)
    private Date relievingDate;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Basic(optional = false)
    @Column(name = "CreatedUserId")
    private int createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "UpdatedUserId")
    private Integer updatedUserId;
    @Column(name = "UpdatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @JoinColumn(name = "HospitalId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MHospital hospitalId;

    public MDoctor() {
    }

    public MDoctor(Integer id) {
        this.id = id;
    }

    public MDoctor(Integer id, String name, String mobileNumber, int specializationId, int createdUserId) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.specializationId = specializationId;
        this.createdUserId = createdUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Date getRelievingDate() {
        return relievingDate;
    }

    public void setRelievingDate(Date relievingDate) {
        this.relievingDate = relievingDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public int getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(int createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Integer updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public MHospital getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(MHospital hospitalId) {
        this.hospitalId = hospitalId;
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
        if (!(object instanceof MDoctor)) {
            return false;
        }
        MDoctor other = (MDoctor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MDoctor[ id=" + id + " ]";
    }
    
}
