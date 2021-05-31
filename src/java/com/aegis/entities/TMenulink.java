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
@Table(name = "t_menulink")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMenulink.findAll", query = "SELECT t FROM TMenulink t")
    , @NamedQuery(name = "TMenulink.findById", query = "SELECT t FROM TMenulink t WHERE t.id = :id")
    , @NamedQuery(name = "TMenulink.findByName", query = "SELECT t FROM TMenulink t WHERE t.name = :name")
    , @NamedQuery(name = "TMenulink.findByRoleId", query = "SELECT t FROM TMenulink t WHERE t.roleId = :roleId")
    , @NamedQuery(name = "TMenulink.findByMenuId", query = "SELECT t FROM TMenulink t WHERE t.menuId = :menuId")
    , @NamedQuery(name = "TMenulink.findByIsParentLink", query = "SELECT t FROM TMenulink t WHERE t.isParentLink = :isParentLink")
    , @NamedQuery(name = "TMenulink.findByParentLinkId", query = "SELECT t FROM TMenulink t WHERE t.parentLinkId = :parentLinkId")
    , @NamedQuery(name = "TMenulink.findByActionName", query = "SELECT t FROM TMenulink t WHERE t.actionName = :actionName")
    , @NamedQuery(name = "TMenulink.findByControllerName", query = "SELECT t FROM TMenulink t WHERE t.controllerName = :controllerName")
    , @NamedQuery(name = "TMenulink.findByAreaName", query = "SELECT t FROM TMenulink t WHERE t.areaName = :areaName")
    , @NamedQuery(name = "TMenulink.findByOrderNumber", query = "SELECT t FROM TMenulink t WHERE t.orderNumber = :orderNumber")
    , @NamedQuery(name = "TMenulink.findByIconClassName", query = "SELECT t FROM TMenulink t WHERE t.iconClassName = :iconClassName")
    , @NamedQuery(name = "TMenulink.findByIsActive", query = "SELECT t FROM TMenulink t WHERE t.isActive = :isActive")
    , @NamedQuery(name = "TMenulink.findByCreatedUserId", query = "SELECT t FROM TMenulink t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TMenulink.findByCreatedOn", query = "SELECT t FROM TMenulink t WHERE t.createdOn = :createdOn")})
public class TMenulink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "RoleId")
    private int roleId;
    @Basic(optional = false)
    @Column(name = "MenuId")
    private int menuId;
    @Basic(optional = false)
    @Column(name = "IsParentLink")
    private boolean isParentLink;
    @Basic(optional = false)
    @Column(name = "ParentLinkId")
    private int parentLinkId;
    @Column(name = "ActionName")
    private String actionName;
    @Column(name = "ControllerName")
    private String controllerName;
    @Column(name = "AreaName")
    private String areaName;
    @Column(name = "OrderNumber")
    private Integer orderNumber;
    @Column(name = "IconClassName")
    private String iconClassName;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TMenulink() {
    }

    public TMenulink(Integer id) {
        this.id = id;
    }

    public TMenulink(Integer id, String name, int roleId, int menuId, boolean isParentLink, int parentLinkId) {
        this.id = id;
        this.name = name;
        this.roleId = roleId;
        this.menuId = menuId;
        this.isParentLink = isParentLink;
        this.parentLinkId = parentLinkId;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public boolean getIsParentLink() {
        return isParentLink;
    }

    public void setIsParentLink(boolean isParentLink) {
        this.isParentLink = isParentLink;
    }

    public int getParentLinkId() {
        return parentLinkId;
    }

    public void setParentLinkId(int parentLinkId) {
        this.parentLinkId = parentLinkId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getIconClassName() {
        return iconClassName;
    }

    public void setIconClassName(String iconClassName) {
        this.iconClassName = iconClassName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
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
        if (!(object instanceof TMenulink)) {
            return false;
        }
        TMenulink other = (TMenulink) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TMenulink[ id=" + id + " ]";
    }
    
}
