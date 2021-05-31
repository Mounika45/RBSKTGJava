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
@Table(name = "t_patientschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPatientschedule.findAll", query = "SELECT t FROM TPatientschedule t")
    , @NamedQuery(name = "TPatientschedule.findById", query = "SELECT t FROM TPatientschedule t WHERE t.id = :id")
    , @NamedQuery(name = "TPatientschedule.findByTranFindingId", query = "SELECT t FROM TPatientschedule t WHERE t.tranFindingId = :tranFindingId")
    , @NamedQuery(name = "TPatientschedule.findByScheduledDatetime", query = "SELECT t FROM TPatientschedule t WHERE t.scheduledDatetime = :scheduledDatetime")
    , @NamedQuery(name = "TPatientschedule.findByScheduleLevelId", query = "SELECT t FROM TPatientschedule t WHERE t.scheduleLevelId = :scheduleLevelId")
    , @NamedQuery(name = "TPatientschedule.findByTreatementType", query = "SELECT t FROM TPatientschedule t WHERE t.treatementType = :treatementType")
    , @NamedQuery(name = "TPatientschedule.findByScheduleTypeId", query = "SELECT t FROM TPatientschedule t WHERE t.scheduleTypeId = :scheduleTypeId")
    , @NamedQuery(name = "TPatientschedule.findByIsPatientAttended", query = "SELECT t FROM TPatientschedule t WHERE t.isPatientAttended = :isPatientAttended")
    , @NamedQuery(name = "TPatientschedule.findByHasFollowupTreatment", query = "SELECT t FROM TPatientschedule t WHERE t.hasFollowupTreatment = :hasFollowupTreatment")
    , @NamedQuery(name = "TPatientschedule.findByRemarks", query = "SELECT t FROM TPatientschedule t WHERE t.remarks = :remarks")
    , @NamedQuery(name = "TPatientschedule.findByCreatedUserId", query = "SELECT t FROM TPatientschedule t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TPatientschedule.findByCreatedDate", query = "SELECT t FROM TPatientschedule t WHERE t.createdDate = :createdDate")})
public class TPatientschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TranFindingId")
    private int tranFindingId;
    @Basic(optional = false)
    @Column(name = "ScheduledDatetime")
    private int scheduledDatetime;
    @Basic(optional = false)
    @Column(name = "ScheduleLevelId")
    private int scheduleLevelId;
    @Basic(optional = false)
    @Column(name = "TreatementType")
    private String treatementType;
    @Basic(optional = false)
    @Column(name = "ScheduleTypeId")
    private int scheduleTypeId;
    @Column(name = "IsPatientAttended")
    private Boolean isPatientAttended;
    @Column(name = "HasFollowupTreatment")
    private Boolean hasFollowupTreatment;
    @Column(name = "Remarks")
    private String remarks;
    @Basic(optional = false)
    @Column(name = "CreatedUserId")
    private int createdUserId;
    @Basic(optional = false)
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public TPatientschedule() {
    }

    public TPatientschedule(Integer id) {
        this.id = id;
    }

    public TPatientschedule(Integer id, int tranFindingId, int scheduledDatetime, int scheduleLevelId, String treatementType, int scheduleTypeId, int createdUserId, Date createdDate) {
        this.id = id;
        this.tranFindingId = tranFindingId;
        this.scheduledDatetime = scheduledDatetime;
        this.scheduleLevelId = scheduleLevelId;
        this.treatementType = treatementType;
        this.scheduleTypeId = scheduleTypeId;
        this.createdUserId = createdUserId;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTranFindingId() {
        return tranFindingId;
    }

    public void setTranFindingId(int tranFindingId) {
        this.tranFindingId = tranFindingId;
    }

    public int getScheduledDatetime() {
        return scheduledDatetime;
    }

    public void setScheduledDatetime(int scheduledDatetime) {
        this.scheduledDatetime = scheduledDatetime;
    }

    public int getScheduleLevelId() {
        return scheduleLevelId;
    }

    public void setScheduleLevelId(int scheduleLevelId) {
        this.scheduleLevelId = scheduleLevelId;
    }

    public String getTreatementType() {
        return treatementType;
    }

    public void setTreatementType(String treatementType) {
        this.treatementType = treatementType;
    }

    public int getScheduleTypeId() {
        return scheduleTypeId;
    }

    public void setScheduleTypeId(int scheduleTypeId) {
        this.scheduleTypeId = scheduleTypeId;
    }

    public Boolean getIsPatientAttended() {
        return isPatientAttended;
    }

    public void setIsPatientAttended(Boolean isPatientAttended) {
        this.isPatientAttended = isPatientAttended;
    }

    public Boolean getHasFollowupTreatment() {
        return hasFollowupTreatment;
    }

    public void setHasFollowupTreatment(Boolean hasFollowupTreatment) {
        this.hasFollowupTreatment = hasFollowupTreatment;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(int createdUserId) {
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
        if (!(object instanceof TPatientschedule)) {
            return false;
        }
        TPatientschedule other = (TPatientschedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TPatientschedule[ id=" + id + " ]";
    }
    
}
