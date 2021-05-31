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
@Table(name = "t_previoustreatment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPrevioustreatment.findAll", query = "SELECT t FROM TPrevioustreatment t")
    , @NamedQuery(name = "TPrevioustreatment.findById", query = "SELECT t FROM TPrevioustreatment t WHERE t.id = :id")
    , @NamedQuery(name = "TPrevioustreatment.findByChildId", query = "SELECT t FROM TPrevioustreatment t WHERE t.childId = :childId")
    , @NamedQuery(name = "TPrevioustreatment.findByYear", query = "SELECT t FROM TPrevioustreatment t WHERE t.year = :year")
    , @NamedQuery(name = "TPrevioustreatment.findByMonth", query = "SELECT t FROM TPrevioustreatment t WHERE t.month = :month")
    , @NamedQuery(name = "TPrevioustreatment.findByTreatment", query = "SELECT t FROM TPrevioustreatment t WHERE t.treatment = :treatment")
    , @NamedQuery(name = "TPrevioustreatment.findByCreatedUserID", query = "SELECT t FROM TPrevioustreatment t WHERE t.createdUserID = :createdUserID")
    , @NamedQuery(name = "TPrevioustreatment.findByCreatedOn", query = "SELECT t FROM TPrevioustreatment t WHERE t.createdOn = :createdOn")
    , @NamedQuery(name = "TPrevioustreatment.findByIsdeleted", query = "SELECT t FROM TPrevioustreatment t WHERE t.isdeleted = :isdeleted")})
public class TPrevioustreatment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ChildId")
    private int childId;
    @Column(name = "Year")
    private String year;
    @Column(name = "Month")
    private String month;
    @Column(name = "Treatment")
    private String treatment;
    @Column(name = "CreatedUserID")
    private Integer createdUserID;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "Isdeleted")
    private Boolean isdeleted;

    public TPrevioustreatment() {
    }

    public TPrevioustreatment(Integer id) {
        this.id = id;
    }

    public TPrevioustreatment(Integer id, int childId) {
        this.id = id;
        this.childId = childId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Integer getCreatedUserID() {
        return createdUserID;
    }

    public void setCreatedUserID(Integer createdUserID) {
        this.createdUserID = createdUserID;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
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
        if (!(object instanceof TPrevioustreatment)) {
            return false;
        }
        TPrevioustreatment other = (TPrevioustreatment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TPrevioustreatment[ id=" + id + " ]";
    }
    
}
