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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "m_teammember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MTeammember.findAll", query = "SELECT m FROM MTeammember m")
    , @NamedQuery(name = "MTeammember.findById", query = "SELECT m FROM MTeammember m WHERE m.id = :id")
    , @NamedQuery(name = "MTeammember.findByName", query = "SELECT m FROM MTeammember m WHERE m.name = :name")
    , @NamedQuery(name = "MTeammember.findByGender", query = "SELECT m FROM MTeammember m WHERE m.gender = :gender")
    , @NamedQuery(name = "MTeammember.findByMobileNumber", query = "SELECT m FROM MTeammember m WHERE m.mobileNumber = :mobileNumber")
    , @NamedQuery(name = "MTeammember.findByFromDate", query = "SELECT m FROM MTeammember m WHERE m.fromDate = :fromDate")
    , @NamedQuery(name = "MTeammember.findByToDate", query = "SELECT m FROM MTeammember m WHERE m.toDate = :toDate")
    , @NamedQuery(name = "MTeammember.findByIsActive", query = "SELECT m FROM MTeammember m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MTeammember.findByCreatedDate", query = "SELECT m FROM MTeammember m WHERE m.createdDate = :createdDate")})
public class MTeammember implements Serializable {

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
    @Column(name = "Gender")
    private Character gender;
    @Basic(optional = false)
    @Column(name = "MobileNumber")
    private String mobileNumber;
    @Column(name = "FromDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;
    @Column(name = "ToDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private int isActive;
    @Basic(optional = false)
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "DesignationId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MDesignation designationId;
    @JoinColumn(name = "TeamId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MTeam teamId;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MUser createdUserId;

    public MTeammember() {
    }

    public MTeammember(Integer id) {
        this.id = id;
    }

    public MTeammember(Integer id, String name, Character gender, String mobileNumber, int isActive, Date createdDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.isActive = isActive;
        this.createdDate = createdDate;
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

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public MDesignation getDesignationId() {
        return designationId;
    }

    public void setDesignationId(MDesignation designationId) {
        this.designationId = designationId;
    }

    public MTeam getTeamId() {
        return teamId;
    }

    public void setTeamId(MTeam teamId) {
        this.teamId = teamId;
    }

    public MUser getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(MUser createdUserId) {
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
        if (!(object instanceof MTeammember)) {
            return false;
        }
        MTeammember other = (MTeammember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MTeammember[ id=" + id + " ]";
    }
    
}
