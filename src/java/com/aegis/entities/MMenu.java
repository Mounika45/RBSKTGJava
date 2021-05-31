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
@Table(name = "m_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MMenu.findAll", query = "SELECT m FROM MMenu m")
    , @NamedQuery(name = "MMenu.findById", query = "SELECT m FROM MMenu m WHERE m.id = :id")
    , @NamedQuery(name = "MMenu.findByName", query = "SELECT m FROM MMenu m WHERE m.name = :name")
    , @NamedQuery(name = "MMenu.findByIconClassName", query = "SELECT m FROM MMenu m WHERE m.iconClassName = :iconClassName")
    , @NamedQuery(name = "MMenu.findByOrderNumber", query = "SELECT m FROM MMenu m WHERE m.orderNumber = :orderNumber")
    , @NamedQuery(name = "MMenu.findByIsActive", query = "SELECT m FROM MMenu m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MMenu.findByCreatedUserId", query = "SELECT m FROM MMenu m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MMenu.findByCreatedDate", query = "SELECT m FROM MMenu m WHERE m.createdDate = :createdDate")})
public class MMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "IconClassName")
    private String iconClassName;
    @Basic(optional = false)
    @Column(name = "OrderNumber")
    private int orderNumber;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public MMenu() {
    }

    public MMenu(Integer id) {
        this.id = id;
    }

    public MMenu(Integer id, String name, int orderNumber, boolean isActive) {
        this.id = id;
        this.name = name;
        this.orderNumber = orderNumber;
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

    public String getIconClassName() {
        return iconClassName;
    }

    public void setIconClassName(String iconClassName) {
        this.iconClassName = iconClassName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
        if (!(object instanceof MMenu)) {
            return false;
        }
        MMenu other = (MMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MMenu[ id=" + id + " ]";
    }
    
}
