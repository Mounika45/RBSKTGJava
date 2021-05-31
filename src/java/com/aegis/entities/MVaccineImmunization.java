/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "m_vaccine_immunization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MVaccineImmunization.findAll", query = "SELECT m FROM MVaccineImmunization m")
    , @NamedQuery(name = "MVaccineImmunization.findByVaccineID", query = "SELECT m FROM MVaccineImmunization m WHERE m.vaccineID = :vaccineID")
    , @NamedQuery(name = "MVaccineImmunization.findByAgeID", query = "SELECT m FROM MVaccineImmunization m WHERE m.ageID = :ageID")
    , @NamedQuery(name = "MVaccineImmunization.findByVaccineName", query = "SELECT m FROM MVaccineImmunization m WHERE m.vaccineName = :vaccineName")
    , @NamedQuery(name = "MVaccineImmunization.findByDistrictID", query = "SELECT m FROM MVaccineImmunization m WHERE m.districtID = :districtID")
    , @NamedQuery(name = "MVaccineImmunization.findByCreatedUserId", query = "SELECT m FROM MVaccineImmunization m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MVaccineImmunization.findByCreatedOn", query = "SELECT m FROM MVaccineImmunization m WHERE m.createdOn = :createdOn")})
public class MVaccineImmunization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Vaccine_ID")
    private Integer vaccineID;
    @Column(name = "Age_ID")
    private Integer ageID;
    @Column(name = "Vaccine_Name")
    private String vaccineName;
    @Column(name = "District_ID")
    private Integer districtID;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "mVaccineImmunization1")
    private MVaccineImmunization mVaccineImmunization;
    @JoinColumn(name = "Vaccine_ID", referencedColumnName = "Vaccine_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MVaccineImmunization mVaccineImmunization1;

    public MVaccineImmunization() {
    }

    public MVaccineImmunization(Integer vaccineID) {
        this.vaccineID = vaccineID;
    }

    public Integer getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(Integer vaccineID) {
        this.vaccineID = vaccineID;
    }

    public Integer getAgeID() {
        return ageID;
    }

    public void setAgeID(Integer ageID) {
        this.ageID = ageID;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public Integer getDistrictID() {
        return districtID;
    }

    public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
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

    public MVaccineImmunization getMVaccineImmunization() {
        return mVaccineImmunization;
    }

    public void setMVaccineImmunization(MVaccineImmunization mVaccineImmunization) {
        this.mVaccineImmunization = mVaccineImmunization;
    }

    public MVaccineImmunization getMVaccineImmunization1() {
        return mVaccineImmunization1;
    }

    public void setMVaccineImmunization1(MVaccineImmunization mVaccineImmunization1) {
        this.mVaccineImmunization1 = mVaccineImmunization1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vaccineID != null ? vaccineID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MVaccineImmunization)) {
            return false;
        }
        MVaccineImmunization other = (MVaccineImmunization) object;
        if ((this.vaccineID == null && other.vaccineID != null) || (this.vaccineID != null && !this.vaccineID.equals(other.vaccineID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MVaccineImmunization[ vaccineID=" + vaccineID + " ]";
    }
    
}
