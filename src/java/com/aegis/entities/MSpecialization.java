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
@Table(name = "m_Specialization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MSpecialization.findAll", query = "SELECT m FROM MSpecialization m")
    , @NamedQuery(name = "MSpecialization.findById", query = "SELECT m FROM MSpecialization m WHERE m.id = :id")
    , @NamedQuery(name = "MSpecialization.findByName", query = "SELECT m FROM MSpecialization m WHERE m.name = :name")
    , @NamedQuery(name = "MSpecialization.findByPreliminaryId", query = "SELECT m FROM MSpecialization m WHERE m.preliminaryId = :preliminaryId")
    , @NamedQuery(name = "MSpecialization.findByFindingId", query = "SELECT m FROM MSpecialization m WHERE m.findingId = :findingId")
    , @NamedQuery(name = "MSpecialization.findByCreatedOn", query = "SELECT m FROM MSpecialization m WHERE m.createdOn = :createdOn")
    , @NamedQuery(name = "MSpecialization.findByCreatedUserId", query = "SELECT m FROM MSpecialization m WHERE m.createdUserId = :createdUserId")})
public class MSpecialization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "PreliminaryId")
    private int preliminaryId;
    @Basic(optional = false)
    @Column(name = "FindingId")
    private int findingId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.DATE)
    private Date createdOn;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;

    public MSpecialization() {
    }

    public MSpecialization(Integer id) {
        this.id = id;
    }

    public MSpecialization(Integer id, String name, int preliminaryId, int findingId) {
        this.id = id;
        this.name = name;
        this.preliminaryId = preliminaryId;
        this.findingId = findingId;
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

    public int getPreliminaryId() {
        return preliminaryId;
    }

    public void setPreliminaryId(int preliminaryId) {
        this.preliminaryId = preliminaryId;
    }

    public int getFindingId() {
        return findingId;
    }

    public void setFindingId(int findingId) {
        this.findingId = findingId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
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
        if (!(object instanceof MSpecialization)) {
            return false;
        }
        MSpecialization other = (MSpecialization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MSpecialization[ id=" + id + " ]";
    }
    
}
