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
@Table(name = "m_hospitaltype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MHospitaltype.findAll", query = "SELECT m FROM MHospitaltype m")
    , @NamedQuery(name = "MHospitaltype.findById", query = "SELECT m FROM MHospitaltype m WHERE m.id = :id")
    , @NamedQuery(name = "MHospitaltype.findByName", query = "SELECT m FROM MHospitaltype m WHERE m.name = :name")
    , @NamedQuery(name = "MHospitaltype.findByDescription", query = "SELECT m FROM MHospitaltype m WHERE m.description = :description")
    , @NamedQuery(name = "MHospitaltype.findByCreatedOn", query = "SELECT m FROM MHospitaltype m WHERE m.createdOn = :createdOn")})
public class MHospitaltype implements Serializable {

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
    @Column(name = "Description")
    private String description;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "Id")
    @ManyToOne
    private MUser createdUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalTypeId")
    private Collection<MHospital> mHospitalCollection;

    public MHospitaltype() {
    }

    public MHospitaltype(Integer id) {
        this.id = id;
    }

    public MHospitaltype(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Collection<MHospital> getMHospitalCollection() {
        return mHospitalCollection;
    }

    public void setMHospitalCollection(Collection<MHospital> mHospitalCollection) {
        this.mHospitalCollection = mHospitalCollection;
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
        if (!(object instanceof MHospitaltype)) {
            return false;
        }
        MHospitaltype other = (MHospitaltype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MHospitaltype[ id=" + id + " ]";
    }
    
}
