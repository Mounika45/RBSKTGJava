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
@Table(name = "m_tile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MTile.findAll", query = "SELECT m FROM MTile m")
    , @NamedQuery(name = "MTile.findById", query = "SELECT m FROM MTile m WHERE m.id = :id")
    , @NamedQuery(name = "MTile.findByName", query = "SELECT m FROM MTile m WHERE m.name = :name")
    , @NamedQuery(name = "MTile.findByDashboardType", query = "SELECT m FROM MTile m WHERE m.dashboardType = :dashboardType")
    , @NamedQuery(name = "MTile.findByIsActive", query = "SELECT m FROM MTile m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MTile.findByCreatedUserId", query = "SELECT m FROM MTile m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MTile.findByCreatedOn", query = "SELECT m FROM MTile m WHERE m.createdOn = :createdOn")})
public class MTile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "DashboardType")
    private String dashboardType;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public MTile() {
    }

    public MTile(Integer id) {
        this.id = id;
    }

    public MTile(Integer id, String name, String dashboardType, boolean isActive) {
        this.id = id;
        this.name = name;
        this.dashboardType = dashboardType;
        this.isActive = isActive;
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

    public String getDashboardType() {
        return dashboardType;
    }

    public void setDashboardType(String dashboardType) {
        this.dashboardType = dashboardType;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MTile)) {
            return false;
        }
        MTile other = (MTile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MTile[ id=" + id + " ]";
    }
    
}
