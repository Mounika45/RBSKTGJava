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
@Table(name = "m_mandal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MMandal.findAll", query = "SELECT m FROM MMandal m")
    , @NamedQuery(name = "MMandal.findById", query = "SELECT m FROM MMandal m WHERE m.id = :id")
    , @NamedQuery(name = "MMandal.findByCode", query = "SELECT m FROM MMandal m WHERE m.code = :code")
    , @NamedQuery(name = "MMandal.findByName", query = "SELECT m FROM MMandal m WHERE m.name = :name")
    , @NamedQuery(name = "MMandal.findByDistrictId", query = "SELECT m FROM MMandal m WHERE m.districtId = :districtId")
    , @NamedQuery(name = "MMandal.findByShortName", query = "SELECT m FROM MMandal m WHERE m.shortName = :shortName")
    , @NamedQuery(name = "MMandal.findByCreatedOn", query = "SELECT m FROM MMandal m WHERE m.createdOn = :createdOn")})
public class MMandal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "DistrictId")
    private int districtId;
    @Column(name = "ShortName")
    private String shortName;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mandalId")
    private Collection<MChildAddress> mChildAddressCollection;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "Id")
    @ManyToOne
    private MUser createdUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mandalId")
    private Collection<MVillage> mVillageCollection;

    public MMandal() {
    }

    public MMandal(Integer id) {
        this.id = id;
    }

    public MMandal(Integer id, String code, String name, int districtId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.districtId = districtId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @XmlTransient
    public Collection<MChildAddress> getMChildAddressCollection() {
        return mChildAddressCollection;
    }

    public void setMChildAddressCollection(Collection<MChildAddress> mChildAddressCollection) {
        this.mChildAddressCollection = mChildAddressCollection;
    }

    public MUser getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(MUser createdUserId) {
        this.createdUserId = createdUserId;
    }

    @XmlTransient
    public Collection<MVillage> getMVillageCollection() {
        return mVillageCollection;
    }

    public void setMVillageCollection(Collection<MVillage> mVillageCollection) {
        this.mVillageCollection = mVillageCollection;
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
        if (!(object instanceof MMandal)) {
            return false;
        }
        MMandal other = (MMandal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MMandal[ id=" + id + " ]";
    }
    
}
