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
@Table(name = "m_ScheduleLevel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MScheduleLevel.findAll", query = "SELECT m FROM MScheduleLevel m")
    , @NamedQuery(name = "MScheduleLevel.findById", query = "SELECT m FROM MScheduleLevel m WHERE m.id = :id")
    , @NamedQuery(name = "MScheduleLevel.findByName", query = "SELECT m FROM MScheduleLevel m WHERE m.name = :name")
    , @NamedQuery(name = "MScheduleLevel.findByDescription", query = "SELECT m FROM MScheduleLevel m WHERE m.description = :description")
    , @NamedQuery(name = "MScheduleLevel.findByCreatedUserId", query = "SELECT m FROM MScheduleLevel m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MScheduleLevel.findByCreatedDate", query = "SELECT m FROM MScheduleLevel m WHERE m.createdDate = :createdDate")})
public class MScheduleLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "CreatedUserId")
    private int createdUserId;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public MScheduleLevel() {
    }

    public MScheduleLevel(Integer id) {
        this.id = id;
    }

    public MScheduleLevel(Integer id, String name, String description, int createdUserId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdUserId = createdUserId;
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

    public int getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(int createdUserId) {
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
        if (!(object instanceof MScheduleLevel)) {
            return false;
        }
        MScheduleLevel other = (MScheduleLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MScheduleLevel[ id=" + id + " ]";
    }
    
}
