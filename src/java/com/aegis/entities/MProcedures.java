/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "m_Procedures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProcedures.findAll", query = "SELECT m FROM MProcedures m")
    , @NamedQuery(name = "MProcedures.findById", query = "SELECT m FROM MProcedures m WHERE m.id = :id")
    , @NamedQuery(name = "MProcedures.findByName", query = "SELECT m FROM MProcedures m WHERE m.name = :name")
    , @NamedQuery(name = "MProcedures.findByIsActive", query = "SELECT m FROM MProcedures m WHERE m.isActive = :isActive")})
public class MProcedures implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;

    public MProcedures() {
    }

    public MProcedures(Integer id) {
        this.id = id;
    }

    public MProcedures(Integer id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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
        if (!(object instanceof MProcedures)) {
            return false;
        }
        MProcedures other = (MProcedures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MProcedures[ id=" + id + " ]";
    }
    
}
