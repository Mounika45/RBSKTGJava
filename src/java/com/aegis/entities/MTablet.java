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
@Table(name = "m_tablet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MTablet.findAll", query = "SELECT m FROM MTablet m")
    , @NamedQuery(name = "MTablet.findById", query = "SELECT m FROM MTablet m WHERE m.id = :id")
    , @NamedQuery(name = "MTablet.findByName", query = "SELECT m FROM MTablet m WHERE m.name = :name")
    , @NamedQuery(name = "MTablet.findByDescription", query = "SELECT m FROM MTablet m WHERE m.description = :description")
    , @NamedQuery(name = "MTablet.findByCreatedUserId", query = "SELECT m FROM MTablet m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MTablet.findByCreatedOn", query = "SELECT m FROM MTablet m WHERE m.createdOn = :createdOn")
    , @NamedQuery(name = "MTablet.findByType", query = "SELECT m FROM MTablet m WHERE m.type = :type")})
public class MTablet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "Type")
    private String type;

    public MTablet() {
    }

    public MTablet(Integer id) {
        this.id = id;
    }

    public MTablet(Integer id, String name) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof MTablet)) {
            return false;
        }
        MTablet other = (MTablet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MTablet[ id=" + id + " ]";
    }
    
}
