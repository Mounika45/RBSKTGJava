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
@Table(name = "m_dentalcauses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MDentalcauses.findAll", query = "SELECT m FROM MDentalcauses m")
    , @NamedQuery(name = "MDentalcauses.findById", query = "SELECT m FROM MDentalcauses m WHERE m.id = :id")
    , @NamedQuery(name = "MDentalcauses.findByName", query = "SELECT m FROM MDentalcauses m WHERE m.name = :name")
    , @NamedQuery(name = "MDentalcauses.findByCreatedUserId", query = "SELECT m FROM MDentalcauses m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MDentalcauses.findByCreatedOn", query = "SELECT m FROM MDentalcauses m WHERE m.createdOn = :createdOn")})
public class MDentalcauses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public MDentalcauses() {
    }

    public MDentalcauses(Integer id) {
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
        if (!(object instanceof MDentalcauses)) {
            return false;
        }
        MDentalcauses other = (MDentalcauses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MDentalcauses[ id=" + id + " ]";
    }
    
}
