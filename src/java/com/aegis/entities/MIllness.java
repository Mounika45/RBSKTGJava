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
@Table(name = "m_illness")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MIllness.findAll", query = "SELECT m FROM MIllness m")
    , @NamedQuery(name = "MIllness.findById", query = "SELECT m FROM MIllness m WHERE m.id = :id")
    , @NamedQuery(name = "MIllness.findByName", query = "SELECT m FROM MIllness m WHERE m.name = :name")
    , @NamedQuery(name = "MIllness.findByType", query = "SELECT m FROM MIllness m WHERE m.type = :type")
    , @NamedQuery(name = "MIllness.findByCreatedUserId", query = "SELECT m FROM MIllness m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MIllness.findByCreatedOn", query = "SELECT m FROM MIllness m WHERE m.createdOn = :createdOn")})
public class MIllness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Type")
    private String type;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public MIllness() {
    }

    public MIllness(Integer id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof MIllness)) {
            return false;
        }
        MIllness other = (MIllness) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MIllness[ id=" + id + " ]";
    }
    
}
