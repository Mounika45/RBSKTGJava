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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "m_schoolcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MSchoolcategory.findAll", query = "SELECT m FROM MSchoolcategory m")
    , @NamedQuery(name = "MSchoolcategory.findById", query = "SELECT m FROM MSchoolcategory m WHERE m.id = :id")
    , @NamedQuery(name = "MSchoolcategory.findByName", query = "SELECT m FROM MSchoolcategory m WHERE m.name = :name")
    , @NamedQuery(name = "MSchoolcategory.findByCreatedUserId", query = "SELECT m FROM MSchoolcategory m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MSchoolcategory.findByCreatedOn", query = "SELECT m FROM MSchoolcategory m WHERE m.createdOn = :createdOn")})
public class MSchoolcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToMany(mappedBy = "categoryId")
    private Collection<MSchool> mSchoolCollection;

    public MSchoolcategory() {
    }

    public MSchoolcategory(Integer id) {
        this.id = id;
    }

    public MSchoolcategory(Integer id, String name) {
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

    @XmlTransient
    public Collection<MSchool> getMSchoolCollection() {
        return mSchoolCollection;
    }

    public void setMSchoolCollection(Collection<MSchool> mSchoolCollection) {
        this.mSchoolCollection = mSchoolCollection;
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
        if (!(object instanceof MSchoolcategory)) {
            return false;
        }
        MSchoolcategory other = (MSchoolcategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MSchoolcategory[ id=" + id + " ]";
    }
    
}
