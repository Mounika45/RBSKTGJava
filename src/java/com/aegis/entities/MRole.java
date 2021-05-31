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
@Table(name = "m_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MRole.findAll", query = "SELECT m FROM MRole m")
    , @NamedQuery(name = "MRole.findById", query = "SELECT m FROM MRole m WHERE m.id = :id")
    , @NamedQuery(name = "MRole.findByName", query = "SELECT m FROM MRole m WHERE m.name = :name")
    , @NamedQuery(name = "MRole.findByDefaultAction", query = "SELECT m FROM MRole m WHERE m.defaultAction = :defaultAction")
    , @NamedQuery(name = "MRole.findByDefaultController", query = "SELECT m FROM MRole m WHERE m.defaultController = :defaultController")
    , @NamedQuery(name = "MRole.findByDefaultArea", query = "SELECT m FROM MRole m WHERE m.defaultArea = :defaultArea")
    , @NamedQuery(name = "MRole.findByIsActive", query = "SELECT m FROM MRole m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MRole.findByCreatedDate", query = "SELECT m FROM MRole m WHERE m.createdDate = :createdDate")})
public class MRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "DefaultAction")
    private String defaultAction;
    @Column(name = "DefaultController")
    private String defaultController;
    @Column(name = "DefaultArea")
    private String defaultArea;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToMany(mappedBy = "roleId")
    private Collection<MServicetreatment> mServicetreatmentCollection;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "Id")
    @ManyToOne
    private MUser createdUserId;

    public MRole() {
    }

    public MRole(Integer id) {
        this.id = id;
    }

    public MRole(Integer id, String name) {
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

    public String getDefaultAction() {
        return defaultAction;
    }

    public void setDefaultAction(String defaultAction) {
        this.defaultAction = defaultAction;
    }

    public String getDefaultController() {
        return defaultController;
    }

    public void setDefaultController(String defaultController) {
        this.defaultController = defaultController;
    }

    public String getDefaultArea() {
        return defaultArea;
    }

    public void setDefaultArea(String defaultArea) {
        this.defaultArea = defaultArea;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Collection<MServicetreatment> getMServicetreatmentCollection() {
        return mServicetreatmentCollection;
    }

    public void setMServicetreatmentCollection(Collection<MServicetreatment> mServicetreatmentCollection) {
        this.mServicetreatmentCollection = mServicetreatmentCollection;
    }

    public MUser getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(MUser createdUserId) {
        this.createdUserId = createdUserId;
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
        if (!(object instanceof MRole)) {
            return false;
        }
        MRole other = (MRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MRole[ id=" + id + " ]";
    }
    
}
