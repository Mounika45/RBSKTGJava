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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "m_phc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MPhc.findAll", query = "SELECT m FROM MPhc m")
    , @NamedQuery(name = "MPhc.findById", query = "SELECT m FROM MPhc m WHERE m.id = :id")
    , @NamedQuery(name = "MPhc.findByCode", query = "SELECT m FROM MPhc m WHERE m.code = :code")
    , @NamedQuery(name = "MPhc.findByName", query = "SELECT m FROM MPhc m WHERE m.name = :name")
    , @NamedQuery(name = "MPhc.findByDistrictId", query = "SELECT m FROM MPhc m WHERE m.districtId = :districtId")
    , @NamedQuery(name = "MPhc.findByMandalId", query = "SELECT m FROM MPhc m WHERE m.mandalId = :mandalId")
    , @NamedQuery(name = "MPhc.findByVillageId", query = "SELECT m FROM MPhc m WHERE m.villageId = :villageId")
    , @NamedQuery(name = "MPhc.findByCreatedUserId", query = "SELECT m FROM MPhc m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MPhc.findByCreatedOn", query = "SELECT m FROM MPhc m WHERE m.createdOn = :createdOn")})
public class MPhc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "DistrictId")
    private int districtId;
    @Basic(optional = false)
    @Column(name = "MandalId")
    private int mandalId;
    @Column(name = "VillageId")
    private Integer villageId;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public MPhc() {
    }

    public MPhc(Integer id) {
        this.id = id;
    }

    public MPhc(Integer id, String name, int districtId, int mandalId) {
        this.id = id;
        this.name = name;
        this.districtId = districtId;
        this.mandalId = mandalId;
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

    public int getMandalId() {
        return mandalId;
    }

    public void setMandalId(int mandalId) {
        this.mandalId = mandalId;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
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
        if (!(object instanceof MPhc)) {
            return false;
        }
        MPhc other = (MPhc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MPhc[ id=" + id + " ]";
    }
    
}
