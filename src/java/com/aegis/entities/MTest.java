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
@Table(name = "m_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MTest.findAll", query = "SELECT m FROM MTest m")
    , @NamedQuery(name = "MTest.findById", query = "SELECT m FROM MTest m WHERE m.id = :id")
    , @NamedQuery(name = "MTest.findByName", query = "SELECT m FROM MTest m WHERE m.name = :name")
    , @NamedQuery(name = "MTest.findByDescription", query = "SELECT m FROM MTest m WHERE m.description = :description")
    , @NamedQuery(name = "MTest.findByHospitalTypeIds", query = "SELECT m FROM MTest m WHERE m.hospitalTypeIds = :hospitalTypeIds")
    , @NamedQuery(name = "MTest.findByTestTypeId", query = "SELECT m FROM MTest m WHERE m.testTypeId = :testTypeId")
    , @NamedQuery(name = "MTest.findByCreatedUserId", query = "SELECT m FROM MTest m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MTest.findByCreatedOn", query = "SELECT m FROM MTest m WHERE m.createdOn = :createdOn")})
public class MTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "HospitalTypeIds")
    private String hospitalTypeIds;
    @Column(name = "TestTypeId")
    private Integer testTypeId;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public MTest() {
    }

    public MTest(Integer id) {
        this.id = id;
    }

    public MTest(Integer id, String name) {
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

    public String getHospitalTypeIds() {
        return hospitalTypeIds;
    }

    public void setHospitalTypeIds(String hospitalTypeIds) {
        this.hospitalTypeIds = hospitalTypeIds;
    }

    public Integer getTestTypeId() {
        return testTypeId;
    }

    public void setTestTypeId(Integer testTypeId) {
        this.testTypeId = testTypeId;
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
        if (!(object instanceof MTest)) {
            return false;
        }
        MTest other = (MTest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MTest[ id=" + id + " ]";
    }
    
}
