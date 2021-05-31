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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "m_child_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MChildAddress.findAll", query = "SELECT m FROM MChildAddress m")
    , @NamedQuery(name = "MChildAddress.findById", query = "SELECT m FROM MChildAddress m WHERE m.id = :id")
    , @NamedQuery(name = "MChildAddress.findByAddress", query = "SELECT m FROM MChildAddress m WHERE m.address = :address")
    , @NamedQuery(name = "MChildAddress.findByDistrictId", query = "SELECT m FROM MChildAddress m WHERE m.districtId = :districtId")
    , @NamedQuery(name = "MChildAddress.findByVillageId", query = "SELECT m FROM MChildAddress m WHERE m.villageId = :villageId")
    , @NamedQuery(name = "MChildAddress.findByIsActive", query = "SELECT m FROM MChildAddress m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MChildAddress.findByCreatedUserId", query = "SELECT m FROM MChildAddress m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MChildAddress.findByCreatedOn", query = "SELECT m FROM MChildAddress m WHERE m.createdOn = :createdOn")})
public class MChildAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "DistrictId")
    private int districtId;
    @Column(name = "VillageId")
    private Integer villageId;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "ChildId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MChild childId;
    @JoinColumn(name = "MandalId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MMandal mandalId;
    @JoinColumn(name = "ID", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MVillage mVillage;

    public MChildAddress() {
    }

    public MChildAddress(Integer id) {
        this.id = id;
    }

    public MChildAddress(Integer id, int districtId, boolean isActive) {
        this.id = id;
        this.districtId = districtId;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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

    public MChild getChildId() {
        return childId;
    }

    public void setChildId(MChild childId) {
        this.childId = childId;
    }

    public MMandal getMandalId() {
        return mandalId;
    }

    public void setMandalId(MMandal mandalId) {
        this.mandalId = mandalId;
    }

    public MVillage getMVillage() {
        return mVillage;
    }

    public void setMVillage(MVillage mVillage) {
        this.mVillage = mVillage;
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
        if (!(object instanceof MChildAddress)) {
            return false;
        }
        MChildAddress other = (MChildAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MChildAddress[ id=" + id + " ]";
    }
    
}
