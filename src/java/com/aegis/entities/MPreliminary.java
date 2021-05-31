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
@Table(name = "m_preliminary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MPreliminary.findAll", query = "SELECT m FROM MPreliminary m")
    , @NamedQuery(name = "MPreliminary.findById", query = "SELECT m FROM MPreliminary m WHERE m.id = :id")
    , @NamedQuery(name = "MPreliminary.findByName", query = "SELECT m FROM MPreliminary m WHERE m.name = :name")
    , @NamedQuery(name = "MPreliminary.findByReferCenters", query = "SELECT m FROM MPreliminary m WHERE m.referCenters = :referCenters")
    , @NamedQuery(name = "MPreliminary.findByCreatedOn", query = "SELECT m FROM MPreliminary m WHERE m.createdOn = :createdOn")})
public class MPreliminary implements Serializable {

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
    @Column(name = "ReferCenters")
    private String referCenters;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "Id")
    @ManyToOne
    private MUser createdUserId;
    @OneToMany(mappedBy = "preliminaryId")
    private Collection<MSymptom> mSymptomCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preliminaryId")
    private Collection<MFinding> mFindingCollection;

    public MPreliminary() {
    }

    public MPreliminary(Integer id) {
        this.id = id;
    }

    public MPreliminary(Integer id, String name, String referCenters) {
        this.id = id;
        this.name = name;
        this.referCenters = referCenters;
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

    public String getReferCenters() {
        return referCenters;
    }

    public void setReferCenters(String referCenters) {
        this.referCenters = referCenters;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public MUser getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(MUser createdUserId) {
        this.createdUserId = createdUserId;
    }

    @XmlTransient
    public Collection<MSymptom> getMSymptomCollection() {
        return mSymptomCollection;
    }

    public void setMSymptomCollection(Collection<MSymptom> mSymptomCollection) {
        this.mSymptomCollection = mSymptomCollection;
    }

    @XmlTransient
    public Collection<MFinding> getMFindingCollection() {
        return mFindingCollection;
    }

    public void setMFindingCollection(Collection<MFinding> mFindingCollection) {
        this.mFindingCollection = mFindingCollection;
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
        if (!(object instanceof MPreliminary)) {
            return false;
        }
        MPreliminary other = (MPreliminary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MPreliminary[ id=" + id + " ]";
    }
    
}
