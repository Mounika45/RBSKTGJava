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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "m_servicetreatment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MServicetreatment.findAll", query = "SELECT m FROM MServicetreatment m")
    , @NamedQuery(name = "MServicetreatment.findById", query = "SELECT m FROM MServicetreatment m WHERE m.id = :id")
    , @NamedQuery(name = "MServicetreatment.findByServiceName", query = "SELECT m FROM MServicetreatment m WHERE m.serviceName = :serviceName")
    , @NamedQuery(name = "MServicetreatment.findByDescription", query = "SELECT m FROM MServicetreatment m WHERE m.description = :description")
    , @NamedQuery(name = "MServicetreatment.findByCreatedUserId", query = "SELECT m FROM MServicetreatment m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MServicetreatment.findByCreatedOn", query = "SELECT m FROM MServicetreatment m WHERE m.createdOn = :createdOn")})
public class MServicetreatment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ServiceName")
    private String serviceName;
    @Column(name = "Description")
    private String description;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "RoleId", referencedColumnName = "Id")
    @ManyToOne
    private MRole roleId;

    public MServicetreatment() {
    }

    public MServicetreatment(Integer id) {
        this.id = id;
    }

    public MServicetreatment(Integer id, String serviceName) {
        this.id = id;
        this.serviceName = serviceName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public MRole getRoleId() {
        return roleId;
    }

    public void setRoleId(MRole roleId) {
        this.roleId = roleId;
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
        if (!(object instanceof MServicetreatment)) {
            return false;
        }
        MServicetreatment other = (MServicetreatment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MServicetreatment[ id=" + id + " ]";
    }
    
}
