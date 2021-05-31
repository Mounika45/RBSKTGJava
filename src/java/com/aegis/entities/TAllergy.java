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
@Table(name = "t_allergy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TAllergy.findAll", query = "SELECT t FROM TAllergy t")
    , @NamedQuery(name = "TAllergy.findById", query = "SELECT t FROM TAllergy t WHERE t.id = :id")
    , @NamedQuery(name = "TAllergy.findByExaminationID", query = "SELECT t FROM TAllergy t WHERE t.examinationID = :examinationID")
    , @NamedQuery(name = "TAllergy.findByAllergyID", query = "SELECT t FROM TAllergy t WHERE t.allergyID = :allergyID")
    , @NamedQuery(name = "TAllergy.findByCreatedUserId", query = "SELECT t FROM TAllergy t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TAllergy.findByCreatedOn", query = "SELECT t FROM TAllergy t WHERE t.createdOn = :createdOn")})
public class TAllergy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "ExaminationID")
    private Integer examinationID;
    @Column(name = "AllergyID")
    private Integer allergyID;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TAllergy() {
    }

    public TAllergy(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExaminationID() {
        return examinationID;
    }

    public void setExaminationID(Integer examinationID) {
        this.examinationID = examinationID;
    }

    public Integer getAllergyID() {
        return allergyID;
    }

    public void setAllergyID(Integer allergyID) {
        this.allergyID = allergyID;
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
        if (!(object instanceof TAllergy)) {
            return false;
        }
        TAllergy other = (TAllergy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TAllergy[ id=" + id + " ]";
    }
    
}
