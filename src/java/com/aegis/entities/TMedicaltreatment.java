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
@Table(name = "t_medicaltreatment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMedicaltreatment.findAll", query = "SELECT t FROM TMedicaltreatment t")
    , @NamedQuery(name = "TMedicaltreatment.findById", query = "SELECT t FROM TMedicaltreatment t WHERE t.id = :id")
    , @NamedQuery(name = "TMedicaltreatment.findByTabletId", query = "SELECT t FROM TMedicaltreatment t WHERE t.tabletId = :tabletId")
    , @NamedQuery(name = "TMedicaltreatment.findByTimings", query = "SELECT t FROM TMedicaltreatment t WHERE t.timings = :timings")
    , @NamedQuery(name = "TMedicaltreatment.findByRemarks", query = "SELECT t FROM TMedicaltreatment t WHERE t.remarks = :remarks")
    , @NamedQuery(name = "TMedicaltreatment.findByReferralTable", query = "SELECT t FROM TMedicaltreatment t WHERE t.referralTable = :referralTable")
    , @NamedQuery(name = "TMedicaltreatment.findByReferralId", query = "SELECT t FROM TMedicaltreatment t WHERE t.referralId = :referralId")
    , @NamedQuery(name = "TMedicaltreatment.findByCreatedUserId", query = "SELECT t FROM TMedicaltreatment t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TMedicaltreatment.findByCreatedDate", query = "SELECT t FROM TMedicaltreatment t WHERE t.createdDate = :createdDate")})
public class TMedicaltreatment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TabletId")
    private int tabletId;
    @Column(name = "Timings")
    private String timings;
    @Column(name = "Remarks")
    private String remarks;
    @Column(name = "ReferralTable")
    private String referralTable;
    @Column(name = "ReferralId")
    private Integer referralId;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public TMedicaltreatment() {
    }

    public TMedicaltreatment(Integer id) {
        this.id = id;
    }

    public TMedicaltreatment(Integer id, int tabletId) {
        this.id = id;
        this.tabletId = tabletId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTabletId() {
        return tabletId;
    }

    public void setTabletId(int tabletId) {
        this.tabletId = tabletId;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getReferralTable() {
        return referralTable;
    }

    public void setReferralTable(String referralTable) {
        this.referralTable = referralTable;
    }

    public Integer getReferralId() {
        return referralId;
    }

    public void setReferralId(Integer referralId) {
        this.referralId = referralId;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
        if (!(object instanceof TMedicaltreatment)) {
            return false;
        }
        TMedicaltreatment other = (TMedicaltreatment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TMedicaltreatment[ id=" + id + " ]";
    }
    
}
