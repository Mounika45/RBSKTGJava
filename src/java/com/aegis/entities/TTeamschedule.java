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
@Table(name = "t_teamschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTeamschedule.findAll", query = "SELECT t FROM TTeamschedule t")
    , @NamedQuery(name = "TTeamschedule.findById", query = "SELECT t FROM TTeamschedule t WHERE t.id = :id")
    , @NamedQuery(name = "TTeamschedule.findByScheduledDate", query = "SELECT t FROM TTeamschedule t WHERE t.scheduledDate = :scheduledDate")
    , @NamedQuery(name = "TTeamschedule.findByVisitType", query = "SELECT t FROM TTeamschedule t WHERE t.visitType = :visitType")
    , @NamedQuery(name = "TTeamschedule.findByIsVisited", query = "SELECT t FROM TTeamschedule t WHERE t.isVisited = :isVisited")
    , @NamedQuery(name = "TTeamschedule.findByRemarks", query = "SELECT t FROM TTeamschedule t WHERE t.remarks = :remarks")
    , @NamedQuery(name = "TTeamschedule.findByTargetStudents", query = "SELECT t FROM TTeamschedule t WHERE t.targetStudents = :targetStudents")
    , @NamedQuery(name = "TTeamschedule.findByDataSource", query = "SELECT t FROM TTeamschedule t WHERE t.dataSource = :dataSource")
    , @NamedQuery(name = "TTeamschedule.findByCreatedDate", query = "SELECT t FROM TTeamschedule t WHERE t.createdDate = :createdDate")
    , @NamedQuery(name = "TTeamschedule.findByAchievedCount", query = "SELECT t FROM TTeamschedule t WHERE t.achievedCount = :achievedCount")
    , @NamedQuery(name = "TTeamschedule.findByScheduleType", query = "SELECT t FROM TTeamschedule t WHERE t.scheduleType = :scheduleType")
    , @NamedQuery(name = "TTeamschedule.findByIsDeleted", query = "SELECT t FROM TTeamschedule t WHERE t.isDeleted = :isDeleted")
    , @NamedQuery(name = "TTeamschedule.findByScreenedDate", query = "SELECT t FROM TTeamschedule t WHERE t.screenedDate = :screenedDate")})
public class TTeamschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ScheduledDate")
    @Temporal(TemporalType.DATE)
    private Date scheduledDate;
    @Basic(optional = false)
    @Column(name = "VisitType")
    private String visitType;
    @Column(name = "IsVisited")
    private Boolean isVisited;
    @Column(name = "Remarks")
    private String remarks;
    @Basic(optional = false)
    @Column(name = "TargetStudents")
    private int targetStudents;
    @Column(name = "DataSource")
    private String dataSource;
    @Basic(optional = false)
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "AchievedCount")
    private Integer achievedCount;
    @Column(name = "ScheduleType")
    private String scheduleType;
    @Column(name = "IsDeleted")
    private Boolean isDeleted;
    @Column(name = "ScreenedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date screenedDate;
    @JoinColumn(name = "AcademicYearID", referencedColumnName = "ID")
    @ManyToOne
    private MAcademicyear academicYearID;
    @JoinColumn(name = "SchoolId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MSchool schoolId;
    @JoinColumn(name = "TeamId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MTeam teamId;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "Id")
    @ManyToOne
    private MUser createdUserId;

    public TTeamschedule() {
    }

    public TTeamschedule(Integer id) {
        this.id = id;
    }

    public TTeamschedule(Integer id, Date scheduledDate, String visitType, int targetStudents, Date createdDate) {
        this.id = id;
        this.scheduledDate = scheduledDate;
        this.visitType = visitType;
        this.targetStudents = targetStudents;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public Boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(Boolean isVisited) {
        this.isVisited = isVisited;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getTargetStudents() {
        return targetStudents;
    }

    public void setTargetStudents(int targetStudents) {
        this.targetStudents = targetStudents;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getAchievedCount() {
        return achievedCount;
    }

    public void setAchievedCount(Integer achievedCount) {
        this.achievedCount = achievedCount;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getScreenedDate() {
        return screenedDate;
    }

    public void setScreenedDate(Date screenedDate) {
        this.screenedDate = screenedDate;
    }

    public MAcademicyear getAcademicYearID() {
        return academicYearID;
    }

    public void setAcademicYearID(MAcademicyear academicYearID) {
        this.academicYearID = academicYearID;
    }

    public MSchool getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(MSchool schoolId) {
        this.schoolId = schoolId;
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
        if (!(object instanceof TTeamschedule)) {
            return false;
        }
        TTeamschedule other = (TTeamschedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TTeamschedule[ id=" + id + " ]";
    }
    
}
