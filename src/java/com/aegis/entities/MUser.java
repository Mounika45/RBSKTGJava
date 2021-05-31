/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "m_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MUser.findAll", query = "SELECT m FROM MUser m")
    , @NamedQuery(name = "MUser.findById", query = "SELECT m FROM MUser m WHERE m.id = :id")
    , @NamedQuery(name = "MUser.findByUserName", query = "SELECT m FROM MUser m WHERE m.userName = :userName")
    , @NamedQuery(name = "MUser.findByPassword", query = "SELECT m FROM MUser m WHERE m.password = :password")
    , @NamedQuery(name = "MUser.findByDisplayName", query = "SELECT m FROM MUser m WHERE m.displayName = :displayName")
    , @NamedQuery(name = "MUser.findByDistrictId", query = "SELECT m FROM MUser m WHERE m.districtId = :districtId")
    , @NamedQuery(name = "MUser.findByRoleId", query = "SELECT m FROM MUser m WHERE m.roleId = :roleId")
    , @NamedQuery(name = "MUser.findByHospitalId", query = "SELECT m FROM MUser m WHERE m.hospitalId = :hospitalId")
    , @NamedQuery(name = "MUser.findByDoctorId", query = "SELECT m FROM MUser m WHERE m.doctorId = :doctorId")
    , @NamedQuery(name = "MUser.findByTeamId", query = "SELECT m FROM MUser m WHERE m.teamId = :teamId")
    , @NamedQuery(name = "MUser.findByIsActive", query = "SELECT m FROM MUser m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MUser.findByCreatedUserId", query = "SELECT m FROM MUser m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MUser.findByCreatedOn", query = "SELECT m FROM MUser m WHERE m.createdOn = :createdOn")
    , @NamedQuery(name = "MUser.findByUpdatedUserId", query = "SELECT m FROM MUser m WHERE m.updatedUserId = :updatedUserId")
    , @NamedQuery(name = "MUser.findByUpdatedOn", query = "SELECT m FROM MUser m WHERE m.updatedOn = :updatedOn")})
public class MUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "UserName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Column(name = "DisplayName")
    private String displayName;
    @Basic(optional = false)
    @Column(name = "DistrictId")
    private int districtId;
    @Basic(optional = false)
    @Column(name = "RoleId")
    private int roleId;
    @Basic(optional = false)
    @Column(name = "HospitalId")
    private int hospitalId;
    @Basic(optional = false)
    @Column(name = "DoctorId")
    private int doctorId;
    @Basic(optional = false)
    @Column(name = "TeamId")
    private int teamId;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "CreatedUserId")
    private int createdUserId;
    @Basic(optional = false)
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "UpdatedUserId")
    private Integer updatedUserId;
    @Column(name = "UpdatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<MAge> mAgeCollection;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<MPreliminary> mPreliminaryCollection;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<MMedium> mMediumCollection;
    @OneToMany(mappedBy = "userID")
    private Collection<TConfirmfindings> tConfirmfindingsCollection;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<MHospitaltype> mHospitaltypeCollection;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<MAgegroup> mAgegroupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdUserId")
    private Collection<MTeammember> mTeammemberCollection;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<MAgeImmunization> mAgeImmunizationCollection;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<MHospital> mHospitalCollection;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<MMandal> mMandalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdUserId")
    private Collection<TotherFindings> totherFindingsCollection;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<TTeamschedule> tTeamscheduleCollection;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<MFinding> mFindingCollection;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<MRole> mRoleCollection;

    public MUser() {
    }

    public MUser(Integer id) {
        this.id = id;
    }

    public MUser(Integer id, String userName, String password, int districtId, int roleId, int hospitalId, int doctorId, int teamId, boolean isActive, int createdUserId, Date createdOn) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.districtId = districtId;
        this.roleId = roleId;
        this.hospitalId = hospitalId;
        this.doctorId = doctorId;
        this.teamId = teamId;
        this.isActive = isActive;
        this.createdUserId = createdUserId;
        this.createdOn = createdOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(int createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Integer updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @XmlTransient
    public Collection<MAge> getMAgeCollection() {
        return mAgeCollection;
    }

    public void setMAgeCollection(Collection<MAge> mAgeCollection) {
        this.mAgeCollection = mAgeCollection;
    }

    @XmlTransient
    public Collection<MPreliminary> getMPreliminaryCollection() {
        return mPreliminaryCollection;
    }

    public void setMPreliminaryCollection(Collection<MPreliminary> mPreliminaryCollection) {
        this.mPreliminaryCollection = mPreliminaryCollection;
    }

    @XmlTransient
    public Collection<MMedium> getMMediumCollection() {
        return mMediumCollection;
    }

    public void setMMediumCollection(Collection<MMedium> mMediumCollection) {
        this.mMediumCollection = mMediumCollection;
    }

    @XmlTransient
    public Collection<TConfirmfindings> getTConfirmfindingsCollection() {
        return tConfirmfindingsCollection;
    }

    public void setTConfirmfindingsCollection(Collection<TConfirmfindings> tConfirmfindingsCollection) {
        this.tConfirmfindingsCollection = tConfirmfindingsCollection;
    }

    @XmlTransient
    public Collection<MHospitaltype> getMHospitaltypeCollection() {
        return mHospitaltypeCollection;
    }

    public void setMHospitaltypeCollection(Collection<MHospitaltype> mHospitaltypeCollection) {
        this.mHospitaltypeCollection = mHospitaltypeCollection;
    }

    @XmlTransient
    public Collection<MAgegroup> getMAgegroupCollection() {
        return mAgegroupCollection;
    }

    public void setMAgegroupCollection(Collection<MAgegroup> mAgegroupCollection) {
        this.mAgegroupCollection = mAgegroupCollection;
    }

    @XmlTransient
    public Collection<MTeammember> getMTeammemberCollection() {
        return mTeammemberCollection;
    }

    public void setMTeammemberCollection(Collection<MTeammember> mTeammemberCollection) {
        this.mTeammemberCollection = mTeammemberCollection;
    }

    @XmlTransient
    public Collection<MAgeImmunization> getMAgeImmunizationCollection() {
        return mAgeImmunizationCollection;
    }

    public void setMAgeImmunizationCollection(Collection<MAgeImmunization> mAgeImmunizationCollection) {
        this.mAgeImmunizationCollection = mAgeImmunizationCollection;
    }

    @XmlTransient
    public Collection<MHospital> getMHospitalCollection() {
        return mHospitalCollection;
    }

    public void setMHospitalCollection(Collection<MHospital> mHospitalCollection) {
        this.mHospitalCollection = mHospitalCollection;
    }

    @XmlTransient
    public Collection<MMandal> getMMandalCollection() {
        return mMandalCollection;
    }

    public void setMMandalCollection(Collection<MMandal> mMandalCollection) {
        this.mMandalCollection = mMandalCollection;
    }

    @XmlTransient
    public Collection<TotherFindings> getTotherFindingsCollection() {
        return totherFindingsCollection;
    }

    public void setTotherFindingsCollection(Collection<TotherFindings> totherFindingsCollection) {
        this.totherFindingsCollection = totherFindingsCollection;
    }

    @XmlTransient
    public Collection<TTeamschedule> getTTeamscheduleCollection() {
        return tTeamscheduleCollection;
    }

    public void setTTeamscheduleCollection(Collection<TTeamschedule> tTeamscheduleCollection) {
        this.tTeamscheduleCollection = tTeamscheduleCollection;
    }

    @XmlTransient
    public Collection<MFinding> getMFindingCollection() {
        return mFindingCollection;
    }

    public void setMFindingCollection(Collection<MFinding> mFindingCollection) {
        this.mFindingCollection = mFindingCollection;
    }

    @XmlTransient
    public Collection<MRole> getMRoleCollection() {
        return mRoleCollection;
    }

    public void setMRoleCollection(Collection<MRole> mRoleCollection) {
        this.mRoleCollection = mRoleCollection;
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
        if (!(object instanceof MUser)) {
            return false;
        }
        MUser other = (MUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MUser[ id=" + id + " ]";
    }
    
}
