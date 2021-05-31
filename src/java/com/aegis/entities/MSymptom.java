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
@Table(name = "m_symptom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MSymptom.findAll", query = "SELECT m FROM MSymptom m")
    , @NamedQuery(name = "MSymptom.findById", query = "SELECT m FROM MSymptom m WHERE m.id = :id")
    , @NamedQuery(name = "MSymptom.findByName", query = "SELECT m FROM MSymptom m WHERE m.name = :name")
    , @NamedQuery(name = "MSymptom.findBySymptomCode", query = "SELECT m FROM MSymptom m WHERE m.symptomCode = :symptomCode")
    , @NamedQuery(name = "MSymptom.findByCreatedUserId", query = "SELECT m FROM MSymptom m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MSymptom.findByCreatedOn", query = "SELECT m FROM MSymptom m WHERE m.createdOn = :createdOn")})
public class MSymptom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "SymptomCode")
    private String symptomCode;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "AgeGroupId", referencedColumnName = "Id")
    @ManyToOne
    private MAgegroup ageGroupId;
    @JoinColumn(name = "PreliminaryId", referencedColumnName = "Id")
    @ManyToOne
    private MPreliminary preliminaryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "symptomId")
    private Collection<TSymptomFinding> tSymptomFindingCollection;

    public MSymptom() {
    }

    public MSymptom(Integer id) {
        this.id = id;
    }

    public MSymptom(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getSymptomCode() {
        return symptomCode;
    }

    public void setSymptomCode(String symptomCode) {
        this.symptomCode = symptomCode;
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

    public MAgegroup getAgeGroupId() {
        return ageGroupId;
    }

    public void setAgeGroupId(MAgegroup ageGroupId) {
        this.ageGroupId = ageGroupId;
    }

    public MPreliminary getPreliminaryId() {
        return preliminaryId;
    }

    public void setPreliminaryId(MPreliminary preliminaryId) {
        this.preliminaryId = preliminaryId;
    }

    @XmlTransient
    public Collection<TSymptomFinding> getTSymptomFindingCollection() {
        return tSymptomFindingCollection;
    }

    public void setTSymptomFindingCollection(Collection<TSymptomFinding> tSymptomFindingCollection) {
        this.tSymptomFindingCollection = tSymptomFindingCollection;
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
        if (!(object instanceof MSymptom)) {
            return false;
        }
        MSymptom other = (MSymptom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MSymptom[ id=" + id + " ]";
    }
    
}
