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
@Table(name = "t_screentimelog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TScreentimelog.findAll", query = "SELECT t FROM TScreentimelog t")
    , @NamedQuery(name = "TScreentimelog.findById", query = "SELECT t FROM TScreentimelog t WHERE t.id = :id")
    , @NamedQuery(name = "TScreentimelog.findByHomeScreen", query = "SELECT t FROM TScreentimelog t WHERE t.homeScreen = :homeScreen")
    , @NamedQuery(name = "TScreentimelog.findByAnthropometrySchoolScreen", query = "SELECT t FROM TScreentimelog t WHERE t.anthropometrySchoolScreen = :anthropometrySchoolScreen")
    , @NamedQuery(name = "TScreentimelog.findByAnthropometryAnganwadiScreen", query = "SELECT t FROM TScreentimelog t WHERE t.anthropometryAnganwadiScreen = :anthropometryAnganwadiScreen")
    , @NamedQuery(name = "TScreentimelog.findByGeneralMedicalQuestionScreen", query = "SELECT t FROM TScreentimelog t WHERE t.generalMedicalQuestionScreen = :generalMedicalQuestionScreen")
    , @NamedQuery(name = "TScreentimelog.findByPreliminaryFindingScreen", query = "SELECT t FROM TScreentimelog t WHERE t.preliminaryFindingScreen = :preliminaryFindingScreen")
    , @NamedQuery(name = "TScreentimelog.findByFindingReferralScreen", query = "SELECT t FROM TScreentimelog t WHERE t.findingReferralScreen = :findingReferralScreen")
    , @NamedQuery(name = "TScreentimelog.findByCreatedDate", query = "SELECT t FROM TScreentimelog t WHERE t.createdDate = :createdDate")})
public class TScreentimelog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "HomeScreen")
    @Temporal(TemporalType.TIME)
    private Date homeScreen;
    @Basic(optional = false)
    @Column(name = "AnthropometrySchoolScreen")
    @Temporal(TemporalType.TIME)
    private Date anthropometrySchoolScreen;
    @Basic(optional = false)
    @Column(name = "AnthropometryAnganwadiScreen")
    @Temporal(TemporalType.TIME)
    private Date anthropometryAnganwadiScreen;
    @Basic(optional = false)
    @Column(name = "GeneralMedicalQuestionScreen")
    @Temporal(TemporalType.TIME)
    private Date generalMedicalQuestionScreen;
    @Basic(optional = false)
    @Column(name = "PreliminaryFindingScreen")
    @Temporal(TemporalType.TIME)
    private Date preliminaryFindingScreen;
    @Basic(optional = false)
    @Column(name = "FindingReferralScreen")
    @Temporal(TemporalType.TIME)
    private Date findingReferralScreen;
    @Basic(optional = false)
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "ChildId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MChild childId;
    @JoinColumn(name = "CreatedTeamId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MTeam createdTeamId;

    public TScreentimelog() {
    }

    public TScreentimelog(Integer id) {
        this.id = id;
    }

    public TScreentimelog(Integer id, Date homeScreen, Date anthropometrySchoolScreen, Date anthropometryAnganwadiScreen, Date generalMedicalQuestionScreen, Date preliminaryFindingScreen, Date findingReferralScreen, Date createdDate) {
        this.id = id;
        this.homeScreen = homeScreen;
        this.anthropometrySchoolScreen = anthropometrySchoolScreen;
        this.anthropometryAnganwadiScreen = anthropometryAnganwadiScreen;
        this.generalMedicalQuestionScreen = generalMedicalQuestionScreen;
        this.preliminaryFindingScreen = preliminaryFindingScreen;
        this.findingReferralScreen = findingReferralScreen;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHomeScreen() {
        return homeScreen;
    }

    public void setHomeScreen(Date homeScreen) {
        this.homeScreen = homeScreen;
    }

    public Date getAnthropometrySchoolScreen() {
        return anthropometrySchoolScreen;
    }

    public void setAnthropometrySchoolScreen(Date anthropometrySchoolScreen) {
        this.anthropometrySchoolScreen = anthropometrySchoolScreen;
    }

    public Date getAnthropometryAnganwadiScreen() {
        return anthropometryAnganwadiScreen;
    }

    public void setAnthropometryAnganwadiScreen(Date anthropometryAnganwadiScreen) {
        this.anthropometryAnganwadiScreen = anthropometryAnganwadiScreen;
    }

    public Date getGeneralMedicalQuestionScreen() {
        return generalMedicalQuestionScreen;
    }

    public void setGeneralMedicalQuestionScreen(Date generalMedicalQuestionScreen) {
        this.generalMedicalQuestionScreen = generalMedicalQuestionScreen;
    }

    public Date getPreliminaryFindingScreen() {
        return preliminaryFindingScreen;
    }

    public void setPreliminaryFindingScreen(Date preliminaryFindingScreen) {
        this.preliminaryFindingScreen = preliminaryFindingScreen;
    }

    public Date getFindingReferralScreen() {
        return findingReferralScreen;
    }

    public void setFindingReferralScreen(Date findingReferralScreen) {
        this.findingReferralScreen = findingReferralScreen;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public MChild getChildId() {
        return childId;
    }

    public void setChildId(MChild childId) {
        this.childId = childId;
    }

    public MTeam getCreatedTeamId() {
        return createdTeamId;
    }

    public void setCreatedTeamId(MTeam createdTeamId) {
        this.createdTeamId = createdTeamId;
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
        if (!(object instanceof TScreentimelog)) {
            return false;
        }
        TScreentimelog other = (TScreentimelog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TScreentimelog[ id=" + id + " ]";
    }
    
}
