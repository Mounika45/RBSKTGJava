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
@Table(name = "t_medicalexamination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMedicalexamination.findAll", query = "SELECT t FROM TMedicalexamination t")
    , @NamedQuery(name = "TMedicalexamination.findById", query = "SELECT t FROM TMedicalexamination t WHERE t.id = :id")
    , @NamedQuery(name = "TMedicalexamination.findByChildId", query = "SELECT t FROM TMedicalexamination t WHERE t.childId = :childId")
    , @NamedQuery(name = "TMedicalexamination.findByHasPreviousTreatmentDetails", query = "SELECT t FROM TMedicalexamination t WHERE t.hasPreviousTreatmentDetails = :hasPreviousTreatmentDetails")
    , @NamedQuery(name = "TMedicalexamination.findByHasFamilyHistory", query = "SELECT t FROM TMedicalexamination t WHERE t.hasFamilyHistory = :hasFamilyHistory")
    , @NamedQuery(name = "TMedicalexamination.findByHasConsanguinity", query = "SELECT t FROM TMedicalexamination t WHERE t.hasConsanguinity = :hasConsanguinity")
    , @NamedQuery(name = "TMedicalexamination.findByConsanguinityLevel", query = "SELECT t FROM TMedicalexamination t WHERE t.consanguinityLevel = :consanguinityLevel")
    , @NamedQuery(name = "TMedicalexamination.findByPersonalHistoryforBelow7Years", query = "SELECT t FROM TMedicalexamination t WHERE t.personalHistoryforBelow7Years = :personalHistoryforBelow7Years")
    , @NamedQuery(name = "TMedicalexamination.findByFamilyHistoryRemarks", query = "SELECT t FROM TMedicalexamination t WHERE t.familyHistoryRemarks = :familyHistoryRemarks")
    , @NamedQuery(name = "TMedicalexamination.findByCreatedUserId", query = "SELECT t FROM TMedicalexamination t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TMedicalexamination.findByCreatedOn", query = "SELECT t FROM TMedicalexamination t WHERE t.createdOn = :createdOn")})
public class TMedicalexamination implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ChildId")
    private int childId;
    @Column(name = "HasPreviousTreatmentDetails")
    private Boolean hasPreviousTreatmentDetails;
    @Column(name = "HasFamilyHistory")
    private Boolean hasFamilyHistory;
    @Column(name = "HasConsanguinity")
    private Boolean hasConsanguinity;
    @Column(name = "ConsanguinityLevel")
    private Integer consanguinityLevel;
    @Column(name = "PersonalHistoryforBelow7Years")
    private String personalHistoryforBelow7Years;
    @Column(name = "FamilyHistoryRemarks")
    private String familyHistoryRemarks;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TMedicalexamination() {
    }

    public TMedicalexamination(Integer id) {
        this.id = id;
    }

    public TMedicalexamination(Integer id, int childId) {
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

    public Boolean getHasPreviousTreatmentDetails() {
        return hasPreviousTreatmentDetails;
    }

    public void setHasPreviousTreatmentDetails(Boolean hasPreviousTreatmentDetails) {
        this.hasPreviousTreatmentDetails = hasPreviousTreatmentDetails;
    }

    public Boolean getHasFamilyHistory() {
        return hasFamilyHistory;
    }

    public void setHasFamilyHistory(Boolean hasFamilyHistory) {
        this.hasFamilyHistory = hasFamilyHistory;
    }

    public Boolean getHasConsanguinity() {
        return hasConsanguinity;
    }

    public void setHasConsanguinity(Boolean hasConsanguinity) {
        this.hasConsanguinity = hasConsanguinity;
    }

    public Integer getConsanguinityLevel() {
        return consanguinityLevel;
    }

    public void setConsanguinityLevel(Integer consanguinityLevel) {
        this.consanguinityLevel = consanguinityLevel;
    }

    public String getPersonalHistoryforBelow7Years() {
        return personalHistoryforBelow7Years;
    }

    public void setPersonalHistoryforBelow7Years(String personalHistoryforBelow7Years) {
        this.personalHistoryforBelow7Years = personalHistoryforBelow7Years;
    }

    public String getFamilyHistoryRemarks() {
        return familyHistoryRemarks;
    }

    public void setFamilyHistoryRemarks(String familyHistoryRemarks) {
        this.familyHistoryRemarks = familyHistoryRemarks;
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
        if (!(object instanceof TMedicalexamination)) {
            return false;
        }
        TMedicalexamination other = (TMedicalexamination) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TMedicalexamination[ id=" + id + " ]";
    }
    
}
