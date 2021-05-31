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
@Table(name = "m_generalmedicalquestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MGeneralmedicalquestion.findAll", query = "SELECT m FROM MGeneralmedicalquestion m")
    , @NamedQuery(name = "MGeneralmedicalquestion.findById", query = "SELECT m FROM MGeneralmedicalquestion m WHERE m.id = :id")
    , @NamedQuery(name = "MGeneralmedicalquestion.findByName", query = "SELECT m FROM MGeneralmedicalquestion m WHERE m.name = :name")
    , @NamedQuery(name = "MGeneralmedicalquestion.findByIsActive", query = "SELECT m FROM MGeneralmedicalquestion m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MGeneralmedicalquestion.findByCreatedUserId", query = "SELECT m FROM MGeneralmedicalquestion m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MGeneralmedicalquestion.findByCreatedOn", query = "SELECT m FROM MGeneralmedicalquestion m WHERE m.createdOn = :createdOn")})
public class MGeneralmedicalquestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public MGeneralmedicalquestion() {
    }

    public MGeneralmedicalquestion(Integer id) {
        this.id = id;
    }

    public MGeneralmedicalquestion(Integer id, String name, boolean isActive) {
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
        if (!(object instanceof MGeneralmedicalquestion)) {
            return false;
        }
        MGeneralmedicalquestion other = (MGeneralmedicalquestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MGeneralmedicalquestion[ id=" + id + " ]";
    }
    
}
