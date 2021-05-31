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
@Table(name = "t_childacademy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TChildacademy.findAll", query = "SELECT t FROM TChildacademy t")
    , @NamedQuery(name = "TChildacademy.findById", query = "SELECT t FROM TChildacademy t WHERE t.id = :id")
    , @NamedQuery(name = "TChildacademy.findByMedium", query = "SELECT t FROM TChildacademy t WHERE t.medium = :medium")
    , @NamedQuery(name = "TChildacademy.findByClass1", query = "SELECT t FROM TChildacademy t WHERE t.class1 = :class1")
    , @NamedQuery(name = "TChildacademy.findByCreatedUserId", query = "SELECT t FROM TChildacademy t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TChildacademy.findByCreatedOn", query = "SELECT t FROM TChildacademy t WHERE t.createdOn = :createdOn")})
public class TChildacademy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Medium")
    private String medium;
    @Column(name = "Class")
    private Integer class1;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "AcademicyearId", referencedColumnName = "ID")
    @ManyToOne
    private MAcademicyear academicyearId;
    @JoinColumn(name = "ChildId", referencedColumnName = "Id")
    @ManyToOne
    private MChild childId;
    @JoinColumn(name = "SchoolID", referencedColumnName = "id")
    @ManyToOne
    private MSchool schoolID;

    public TChildacademy() {
    }

    public TChildacademy(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Integer getClass1() {
        return class1;
    }

    public void setClass1(Integer class1) {
        this.class1 = class1;
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

    public MAcademicyear getAcademicyearId() {
        return academicyearId;
    }

    public void setAcademicyearId(MAcademicyear academicyearId) {
        this.academicyearId = academicyearId;
    }

    public MChild getChildId() {
        return childId;
    }

    public void setChildId(MChild childId) {
        this.childId = childId;
    }

    public MSchool getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(MSchool schoolID) {
        this.schoolID = schoolID;
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
        if (!(object instanceof TChildacademy)) {
            return false;
        }
        TChildacademy other = (TChildacademy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TChildacademy[ id=" + id + " ]";
    }
    
}
