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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "m_hospital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MHospital.findAll", query = "SELECT m FROM MHospital m")
    , @NamedQuery(name = "MHospital.findById", query = "SELECT m FROM MHospital m WHERE m.id = :id")
    , @NamedQuery(name = "MHospital.findByName", query = "SELECT m FROM MHospital m WHERE m.name = :name")
    , @NamedQuery(name = "MHospital.findBySpeciality", query = "SELECT m FROM MHospital m WHERE m.speciality = :speciality")
    , @NamedQuery(name = "MHospital.findByDistrictId", query = "SELECT m FROM MHospital m WHERE m.districtId = :districtId")
    , @NamedQuery(name = "MHospital.findByIsActive", query = "SELECT m FROM MHospital m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MHospital.findByCreatedOn", query = "SELECT m FROM MHospital m WHERE m.createdOn = :createdOn")})
public class MHospital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Speciality")
    private String speciality;
    @Basic(optional = false)
    @Column(name = "DistrictId")
    private int districtId;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalId")
    private Collection<MDoctor> mDoctorCollection;
    @JoinColumn(name = "HospitalTypeId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MHospitaltype hospitalTypeId;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "Id")
    @ManyToOne
    private MUser createdUserId;

    public MHospital() {
    }

    public MHospital(Integer id) {
        this.id = id;
    }

    public MHospital(Integer id, String name, int districtId, boolean isActive) {
        this.id = id;
        this.name = name;
        this.districtId = districtId;
        this.isActive = isActive;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @XmlTransient
    public Collection<MDoctor> getMDoctorCollection() {
        return mDoctorCollection;
    }

    public void setMDoctorCollection(Collection<MDoctor> mDoctorCollection) {
        this.mDoctorCollection = mDoctorCollection;
    }

    public MHospitaltype getHospitalTypeId() {
        return hospitalTypeId;
    }

    public void setHospitalTypeId(MHospitaltype hospitalTypeId) {
        this.hospitalTypeId = hospitalTypeId;
    }

    public MUser getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(MUser createdUserId) {
        this.createdUserId = createdUserId;
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
        if (!(object instanceof MHospital)) {
            return false;
        }
        MHospital other = (MHospital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MHospital[ id=" + id + " ]";
    }
    
}
