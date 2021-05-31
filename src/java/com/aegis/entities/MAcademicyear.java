/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "m_academicyear")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MAcademicyear.findAll", query = "SELECT m FROM MAcademicyear m")
    , @NamedQuery(name = "MAcademicyear.findById", query = "SELECT m FROM MAcademicyear m WHERE m.id = :id")
    , @NamedQuery(name = "MAcademicyear.findByName", query = "SELECT m FROM MAcademicyear m WHERE m.name = :name")
    , @NamedQuery(name = "MAcademicyear.findByIsActive", query = "SELECT m FROM MAcademicyear m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MAcademicyear.findByStartdate", query = "SELECT m FROM MAcademicyear m WHERE m.startdate = :startdate")
    , @NamedQuery(name = "MAcademicyear.findByEnddate", query = "SELECT m FROM MAcademicyear m WHERE m.enddate = :enddate")
    , @NamedQuery(name = "MAcademicyear.findByCreatedUserId", query = "SELECT m FROM MAcademicyear m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MAcademicyear.findByCreatedOn", query = "SELECT m FROM MAcademicyear m WHERE m.createdOn = :createdOn")})
public class MAcademicyear implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Column(name = "Startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "Enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToMany(mappedBy = "academicyearId")
    private Collection<TChildacademy> tChildacademyCollection;
    @OneToMany(mappedBy = "academicYearID")
    private Collection<TTeamschedule> tTeamscheduleCollection;

    public MAcademicyear() {
    }

    public MAcademicyear(Integer id) {
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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

    @XmlTransient
    public Collection<TChildacademy> getTChildacademyCollection() {
        return tChildacademyCollection;
    }

    public void setTChildacademyCollection(Collection<TChildacademy> tChildacademyCollection) {
        this.tChildacademyCollection = tChildacademyCollection;
    }

    @XmlTransient
    public Collection<TTeamschedule> getTTeamscheduleCollection() {
        return tTeamscheduleCollection;
    }

    public void setTTeamscheduleCollection(Collection<TTeamschedule> tTeamscheduleCollection) {
        this.tTeamscheduleCollection = tTeamscheduleCollection;
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
        if (!(object instanceof MAcademicyear)) {
            return false;
        }
        MAcademicyear other = (MAcademicyear) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MAcademicyear[ id=" + id + " ]";
    }
    
}
