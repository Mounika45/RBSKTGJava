/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "m_village")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MVillage.findAll", query = "SELECT m FROM MVillage m")
    , @NamedQuery(name = "MVillage.findById", query = "SELECT m FROM MVillage m WHERE m.id = :id")
    , @NamedQuery(name = "MVillage.findByCode", query = "SELECT m FROM MVillage m WHERE m.code = :code")
    , @NamedQuery(name = "MVillage.findByName", query = "SELECT m FROM MVillage m WHERE m.name = :name")
    , @NamedQuery(name = "MVillage.findByCreatedUserId", query = "SELECT m FROM MVillage m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MVillage.findByCreatedOn", query = "SELECT m FROM MVillage m WHERE m.createdOn = :createdOn")})
public class MVillage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "mVillage")
    private MChildAddress mChildAddress;
    @JoinColumn(name = "MandalId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MMandal mandalId;

    public MVillage() {
    }

    public MVillage(Integer id) {
        this.id = id;
    }

    public MVillage(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public MChildAddress getMChildAddress() {
        return mChildAddress;
    }

    public void setMChildAddress(MChildAddress mChildAddress) {
        this.mChildAddress = mChildAddress;
    }

    public MMandal getMandalId() {
        return mandalId;
    }

    public void setMandalId(MMandal mandalId) {
        this.mandalId = mandalId;
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
        if (!(object instanceof MVillage)) {
            return false;
        }
        MVillage other = (MVillage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MVillage[ id=" + id + " ]";
    }
    
}
