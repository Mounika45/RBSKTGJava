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
@Table(name = "t_finding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TFinding.findAll", query = "SELECT t FROM TFinding t")
    , @NamedQuery(name = "TFinding.findById", query = "SELECT t FROM TFinding t WHERE t.id = :id")
    , @NamedQuery(name = "TFinding.findBySymptomId", query = "SELECT t FROM TFinding t WHERE t.symptomId = :symptomId")
    , @NamedQuery(name = "TFinding.findByFindingId", query = "SELECT t FROM TFinding t WHERE t.findingId = :findingId")
    , @NamedQuery(name = "TFinding.findByTeamId", query = "SELECT t FROM TFinding t WHERE t.teamId = :teamId")
    , @NamedQuery(name = "TFinding.findByTeamScheduleID", query = "SELECT t FROM TFinding t WHERE t.teamScheduleID = :teamScheduleID")
    , @NamedQuery(name = "TFinding.findByChildId", query = "SELECT t FROM TFinding t WHERE t.childId = :childId")
    , @NamedQuery(name = "TFinding.findByHospitalId", query = "SELECT t FROM TFinding t WHERE t.hospitalId = :hospitalId")
    , @NamedQuery(name = "TFinding.findByFindingStatusId", query = "SELECT t FROM TFinding t WHERE t.findingStatusId = :findingStatusId")
    , @NamedQuery(name = "TFinding.findByHasSpotTreatment", query = "SELECT t FROM TFinding t WHERE t.hasSpotTreatment = :hasSpotTreatment")
    , @NamedQuery(name = "TFinding.findByCreatedUserId", query = "SELECT t FROM TFinding t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TFinding.findByCreatedDate", query = "SELECT t FROM TFinding t WHERE t.createdDate = :createdDate")
    , @NamedQuery(name = "TFinding.findByLastModifiedDate", query = "SELECT t FROM TFinding t WHERE t.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "TFinding.findByLastModifiedUserId", query = "SELECT t FROM TFinding t WHERE t.lastModifiedUserId = :lastModifiedUserId")})
public class TFinding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "SymptomId")
    private String symptomId;
    @Basic(optional = false)
    @Column(name = "FindingId")
    private int findingId;
    @Basic(optional = false)
    @Column(name = "TeamId")
    private int teamId;
    @Column(name = "TeamScheduleID")
    private Integer teamScheduleID;
    @Basic(optional = false)
    @Column(name = "ChildId")
    private int childId;
    @Basic(optional = false)
    @Column(name = "HospitalId")
    private int hospitalId;
    @Basic(optional = false)
    @Column(name = "FindingStatusId")
    private int findingStatusId;
    @Column(name = "HasSpotTreatment")
    private Boolean hasSpotTreatment;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Basic(optional = false)
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "LastModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Column(name = "LastModifiedUserId")
    private Integer lastModifiedUserId;

    public TFinding() {
    }

    public TFinding(Integer id) {
        this.id = id;
    }

    public TFinding(Integer id, int findingId, int teamId, int childId, int hospitalId, int findingStatusId, Date createdDate) {
        this.id = id;
        this.findingId = findingId;
        this.teamId = teamId;
        this.childId = childId;
        this.hospitalId = hospitalId;
        this.findingStatusId = findingStatusId;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(String symptomId) {
        this.symptomId = symptomId;
    }

    public int getFindingId() {
        return findingId;
    }

    public void setFindingId(int findingId) {
        this.findingId = findingId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Integer getTeamScheduleID() {
        return teamScheduleID;
    }

    public void setTeamScheduleID(Integer teamScheduleID) {
        this.teamScheduleID = teamScheduleID;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getFindingStatusId() {
        return findingStatusId;
    }

    public void setFindingStatusId(int findingStatusId) {
        this.findingStatusId = findingStatusId;
    }

    public Boolean getHasSpotTreatment() {
        return hasSpotTreatment;
    }

    public void setHasSpotTreatment(Boolean hasSpotTreatment) {
        this.hasSpotTreatment = hasSpotTreatment;
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

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getLastModifiedUserId() {
        return lastModifiedUserId;
    }

    public void setLastModifiedUserId(Integer lastModifiedUserId) {
        this.lastModifiedUserId = lastModifiedUserId;
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
        if (!(object instanceof TFinding)) {
            return false;
        }
        TFinding other = (TFinding) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TFinding[ id=" + id + " ]";
    }
    
}
