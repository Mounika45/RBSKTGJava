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
@Table(name = "m_district")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MDistrict.findAll", query = "SELECT m FROM MDistrict m")
    , @NamedQuery(name = "MDistrict.findById", query = "SELECT m FROM MDistrict m WHERE m.id = :id")
    , @NamedQuery(name = "MDistrict.findByCode", query = "SELECT m FROM MDistrict m WHERE m.code = :code")
    , @NamedQuery(name = "MDistrict.findByName", query = "SELECT m FROM MDistrict m WHERE m.name = :name")
    , @NamedQuery(name = "MDistrict.findByDEICDistrictId", query = "SELECT m FROM MDistrict m WHERE m.dEICDistrictId = :dEICDistrictId")
    , @NamedQuery(name = "MDistrict.findByCreatedUserId", query = "SELECT m FROM MDistrict m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MDistrict.findByCreatedon", query = "SELECT m FROM MDistrict m WHERE m.createdon = :createdon")})
public class MDistrict implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "DEICDistrictId")
    private Integer dEICDistrictId;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "Createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;

    public MDistrict() {
    }

    public MDistrict(Integer id) {
        this.id = id;
    }

    public MDistrict(Integer id, String code, String name) {
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

    public Integer getDEICDistrictId() {
        return dEICDistrictId;
    }

    public void setDEICDistrictId(Integer dEICDistrictId) {
        this.dEICDistrictId = dEICDistrictId;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
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
        if (!(object instanceof MDistrict)) {
            return false;
        }
        MDistrict other = (MDistrict) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MDistrict[ id=" + id + " ]";
    }
    
}
