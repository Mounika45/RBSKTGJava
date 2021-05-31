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
@Table(name = "m_DentalTreatmentTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MDentalTreatmentTypes.findAll", query = "SELECT m FROM MDentalTreatmentTypes m")
    , @NamedQuery(name = "MDentalTreatmentTypes.findById", query = "SELECT m FROM MDentalTreatmentTypes m WHERE m.id = :id")
    , @NamedQuery(name = "MDentalTreatmentTypes.findByTreatmentType", query = "SELECT m FROM MDentalTreatmentTypes m WHERE m.treatmentType = :treatmentType")
    , @NamedQuery(name = "MDentalTreatmentTypes.findByCreatedUserId", query = "SELECT m FROM MDentalTreatmentTypes m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MDentalTreatmentTypes.findByCreatedOn", query = "SELECT m FROM MDentalTreatmentTypes m WHERE m.createdOn = :createdOn")})
public class MDentalTreatmentTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "TreatmentType")
    private String treatmentType;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public MDentalTreatmentTypes() {
    }

    public MDentalTreatmentTypes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
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
        if (!(object instanceof MDentalTreatmentTypes)) {
            return false;
        }
        MDentalTreatmentTypes other = (MDentalTreatmentTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MDentalTreatmentTypes[ id=" + id + " ]";
    }
    
}
