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
@Table(name = "m_SchoolPrincipal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MSchoolPrincipal.findAll", query = "SELECT m FROM MSchoolPrincipal m")
    , @NamedQuery(name = "MSchoolPrincipal.findById", query = "SELECT m FROM MSchoolPrincipal m WHERE m.id = :id")
    , @NamedQuery(name = "MSchoolPrincipal.findByPrincipalName", query = "SELECT m FROM MSchoolPrincipal m WHERE m.principalName = :principalName")
    , @NamedQuery(name = "MSchoolPrincipal.findByFromDate", query = "SELECT m FROM MSchoolPrincipal m WHERE m.fromDate = :fromDate")
    , @NamedQuery(name = "MSchoolPrincipal.findByToDate", query = "SELECT m FROM MSchoolPrincipal m WHERE m.toDate = :toDate")
    , @NamedQuery(name = "MSchoolPrincipal.findByIsActive", query = "SELECT m FROM MSchoolPrincipal m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MSchoolPrincipal.findByMobileNumber", query = "SELECT m FROM MSchoolPrincipal m WHERE m.mobileNumber = :mobileNumber")
    , @NamedQuery(name = "MSchoolPrincipal.findByEmailID", query = "SELECT m FROM MSchoolPrincipal m WHERE m.emailID = :emailID")
    , @NamedQuery(name = "MSchoolPrincipal.findByCreatedUserId", query = "SELECT m FROM MSchoolPrincipal m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MSchoolPrincipal.findByCreatedOn", query = "SELECT m FROM MSchoolPrincipal m WHERE m.createdOn = :createdOn")})
public class MSchoolPrincipal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PrincipalName")
    private String principalName;
    @Basic(optional = false)
    @Column(name = "FromDate")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Basic(optional = false)
    @Column(name = "ToDate")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "MobileNumber")
    private String mobileNumber;
    @Column(name = "EmailID")
    private String emailID;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "SchoolId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MSchool schoolId;

    public MSchoolPrincipal() {
    }

    public MSchoolPrincipal(Integer id) {
        this.id = id;
    }

    public MSchoolPrincipal(Integer id, String principalName, Date fromDate, Date toDate, boolean isActive) {
        this.id = id;
        this.principalName = principalName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
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

    public MSchool getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(MSchool schoolId) {
        this.schoolId = schoolId;
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
        if (!(object instanceof MSchoolPrincipal)) {
            return false;
        }
        MSchoolPrincipal other = (MSchoolPrincipal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MSchoolPrincipal[ id=" + id + " ]";
    }
    
}
