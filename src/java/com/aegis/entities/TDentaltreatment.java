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
@Table(name = "t_dentaltreatment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDentaltreatment.findAll", query = "SELECT t FROM TDentaltreatment t")
    , @NamedQuery(name = "TDentaltreatment.findById", query = "SELECT t FROM TDentaltreatment t WHERE t.id = :id")
    , @NamedQuery(name = "TDentaltreatment.findByDentalId", query = "SELECT t FROM TDentaltreatment t WHERE t.dentalId = :dentalId")
    , @NamedQuery(name = "TDentaltreatment.findByTreatmentType", query = "SELECT t FROM TDentaltreatment t WHERE t.treatmentType = :treatmentType")
    , @NamedQuery(name = "TDentaltreatment.findByScheduledate", query = "SELECT t FROM TDentaltreatment t WHERE t.scheduledate = :scheduledate")
    , @NamedQuery(name = "TDentaltreatment.findByTreatmentPlan", query = "SELECT t FROM TDentaltreatment t WHERE t.treatmentPlan = :treatmentPlan")
    , @NamedQuery(name = "TDentaltreatment.findByAttendedStatus", query = "SELECT t FROM TDentaltreatment t WHERE t.attendedStatus = :attendedStatus")
    , @NamedQuery(name = "TDentaltreatment.findByObservation", query = "SELECT t FROM TDentaltreatment t WHERE t.observation = :observation")
    , @NamedQuery(name = "TDentaltreatment.findByRemarks", query = "SELECT t FROM TDentaltreatment t WHERE t.remarks = :remarks")
    , @NamedQuery(name = "TDentaltreatment.findByCreatedBy", query = "SELECT t FROM TDentaltreatment t WHERE t.createdBy = :createdBy")
    , @NamedQuery(name = "TDentaltreatment.findByCreatedOn", query = "SELECT t FROM TDentaltreatment t WHERE t.createdOn = :createdOn")
    , @NamedQuery(name = "TDentaltreatment.findByModifiedBy", query = "SELECT t FROM TDentaltreatment t WHERE t.modifiedBy = :modifiedBy")
    , @NamedQuery(name = "TDentaltreatment.findByModifiedOn", query = "SELECT t FROM TDentaltreatment t WHERE t.modifiedOn = :modifiedOn")})
public class TDentaltreatment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "DentalId")
    private Integer dentalId;
    @Column(name = "TreatmentType")
    private Integer treatmentType;
    @Column(name = "Scheduledate")
    @Temporal(TemporalType.DATE)
    private Date scheduledate;
    @Column(name = "TreatmentPlan")
    private String treatmentPlan;
    @Column(name = "AttendedStatus")
    private Boolean attendedStatus;
    @Column(name = "Observation")
    private String observation;
    @Column(name = "Remarks")
    private String remarks;
    @Column(name = "CreatedBy")
    private Integer createdBy;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "ModifiedBy")
    private Integer modifiedBy;
    @Column(name = "ModifiedOn")
    @Temporal(TemporalType.DATE)
    private Date modifiedOn;

    public TDentaltreatment() {
    }

    public TDentaltreatment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDentalId() {
        return dentalId;
    }

    public void setDentalId(Integer dentalId) {
        this.dentalId = dentalId;
    }

    public Integer getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(Integer treatmentType) {
        this.treatmentType = treatmentType;
    }

    public Date getScheduledate() {
        return scheduledate;
    }

    public void setScheduledate(Date scheduledate) {
        this.scheduledate = scheduledate;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public Boolean getAttendedStatus() {
        return attendedStatus;
    }

    public void setAttendedStatus(Boolean attendedStatus) {
        this.attendedStatus = attendedStatus;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
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
        if (!(object instanceof TDentaltreatment)) {
            return false;
        }
        TDentaltreatment other = (TDentaltreatment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TDentaltreatment[ id=" + id + " ]";
    }
    
}
