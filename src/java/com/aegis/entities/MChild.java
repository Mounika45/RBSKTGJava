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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "m_child")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MChild.findAll", query = "SELECT m FROM MChild m")
    , @NamedQuery(name = "MChild.findById", query = "SELECT m FROM MChild m WHERE m.id = :id")
    , @NamedQuery(name = "MChild.findByUCId", query = "SELECT m FROM MChild m WHERE m.uCId = :uCId")
    , @NamedQuery(name = "MChild.findByName", query = "SELECT m FROM MChild m WHERE m.name = :name")
    , @NamedQuery(name = "MChild.findByFatherName", query = "SELECT m FROM MChild m WHERE m.fatherName = :fatherName")
    , @NamedQuery(name = "MChild.findByMotherName", query = "SELECT m FROM MChild m WHERE m.motherName = :motherName")
    , @NamedQuery(name = "MChild.findByDateofBirth", query = "SELECT m FROM MChild m WHERE m.dateofBirth = :dateofBirth")
    , @NamedQuery(name = "MChild.findByGender", query = "SELECT m FROM MChild m WHERE m.gender = :gender")
    , @NamedQuery(name = "MChild.findByCaste", query = "SELECT m FROM MChild m WHERE m.caste = :caste")
    , @NamedQuery(name = "MChild.findByReligion", query = "SELECT m FROM MChild m WHERE m.religion = :religion")
    , @NamedQuery(name = "MChild.findByMotherTongue", query = "SELECT m FROM MChild m WHERE m.motherTongue = :motherTongue")
    , @NamedQuery(name = "MChild.findByDisability", query = "SELECT m FROM MChild m WHERE m.disability = :disability")
    , @NamedQuery(name = "MChild.findByMobileNumber", query = "SELECT m FROM MChild m WHERE m.mobileNumber = :mobileNumber")
    , @NamedQuery(name = "MChild.findByAadharNumber", query = "SELECT m FROM MChild m WHERE m.aadharNumber = :aadharNumber")
    , @NamedQuery(name = "MChild.findByClass1", query = "SELECT m FROM MChild m WHERE m.class1 = :class1")
    , @NamedQuery(name = "MChild.findByCreatedTeamId", query = "SELECT m FROM MChild m WHERE m.createdTeamId = :createdTeamId")
    , @NamedQuery(name = "MChild.findByCreatedDate", query = "SELECT m FROM MChild m WHERE m.createdDate = :createdDate")
    , @NamedQuery(name = "MChild.findByLastUpdatedTeamId", query = "SELECT m FROM MChild m WHERE m.lastUpdatedTeamId = :lastUpdatedTeamId")
    , @NamedQuery(name = "MChild.findByLastUpdatedDate", query = "SELECT m FROM MChild m WHERE m.lastUpdatedDate = :lastUpdatedDate")
    , @NamedQuery(name = "MChild.findByGovtUDIC", query = "SELECT m FROM MChild m WHERE m.govtUDIC = :govtUDIC")
    , @NamedQuery(name = "MChild.findByInsertedDate", query = "SELECT m FROM MChild m WHERE m.insertedDate = :insertedDate")})
public class MChild implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "UCId")
    private long uCId;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "FatherName")
    private String fatherName;
    @Basic(optional = false)
    @Column(name = "MotherName")
    private String motherName;
    @Column(name = "DateofBirth")
    @Temporal(TemporalType.DATE)
    private Date dateofBirth;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "Caste")
    private String caste;
    @Basic(optional = false)
    @Column(name = "Religion")
    private String religion;
    @Column(name = "MotherTongue")
    private String motherTongue;
    @Basic(optional = false)
    @Column(name = "Disability")
    private String disability;
    @Column(name = "MobileNumber")
    private String mobileNumber;
    @Column(name = "AadharNumber")
    private String aadharNumber;
    @Column(name = "Class")
    private Integer class1;
    @Column(name = "CreatedTeamId")
    private Integer createdTeamId;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "LastUpdatedTeamId")
    private Integer lastUpdatedTeamId;
    @Column(name = "LastUpdatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;
    @Column(name = "GovtUDIC")
    private String govtUDIC;
    @Column(name = "InsertedDate")
    @Temporal(TemporalType.DATE)
    private Date insertedDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "mChild1")
    private MChild mChild;
    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MChild mChild1;
    @JoinColumn(name = "SchoolId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MSchool schoolId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "childId")
    private Collection<TChildpersonalhistory> tChildpersonalhistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "childid")
    private Collection<TfindingImages> tfindingImagesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "childId")
    private Collection<TAnthropometry> tAnthropometryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "childId")
    private Collection<MChildAddress> mChildAddressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "childId")
    private Collection<MChildhistory> mChildhistoryCollection;
    @OneToMany(mappedBy = "childId")
    private Collection<TChildacademy> tChildacademyCollection;
    @OneToMany(mappedBy = "childId")
    private Collection<TChiefcomplaints> tChiefcomplaintsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "mChild")
    private TotherFindings totherFindings;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "childId")
    private Collection<TScreentimelog> tScreentimelogCollection;

    public MChild() {
    }

    public MChild(Integer id) {
        this.id = id;
    }

    public MChild(Integer id, long uCId, String name, String fatherName, String motherName, String gender, String caste, String religion, String disability) {
        this.id = id;
        this.uCId = uCId;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.gender = gender;
        this.caste = caste;
        this.religion = religion;
        this.disability = disability;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getUCId() {
        return uCId;
    }

    public void setUCId(long uCId) {
        this.uCId = uCId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public Integer getClass1() {
        return class1;
    }

    public void setClass1(Integer class1) {
        this.class1 = class1;
    }

    public Integer getCreatedTeamId() {
        return createdTeamId;
    }

    public void setCreatedTeamId(Integer createdTeamId) {
        this.createdTeamId = createdTeamId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getLastUpdatedTeamId() {
        return lastUpdatedTeamId;
    }

    public void setLastUpdatedTeamId(Integer lastUpdatedTeamId) {
        this.lastUpdatedTeamId = lastUpdatedTeamId;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getGovtUDIC() {
        return govtUDIC;
    }

    public void setGovtUDIC(String govtUDIC) {
        this.govtUDIC = govtUDIC;
    }

    public Date getInsertedDate() {
        return insertedDate;
    }

    public void setInsertedDate(Date insertedDate) {
        this.insertedDate = insertedDate;
    }

    public MChild getMChild() {
        return mChild;
    }

    public void setMChild(MChild mChild) {
        this.mChild = mChild;
    }

    public MChild getMChild1() {
        return mChild1;
    }

    public void setMChild1(MChild mChild1) {
        this.mChild1 = mChild1;
    }

    public MSchool getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(MSchool schoolId) {
        this.schoolId = schoolId;
    }

    @XmlTransient
    public Collection<TChildpersonalhistory> getTChildpersonalhistoryCollection() {
        return tChildpersonalhistoryCollection;
    }

    public void setTChildpersonalhistoryCollection(Collection<TChildpersonalhistory> tChildpersonalhistoryCollection) {
        this.tChildpersonalhistoryCollection = tChildpersonalhistoryCollection;
    }

    @XmlTransient
    public Collection<TfindingImages> getTfindingImagesCollection() {
        return tfindingImagesCollection;
    }

    public void setTfindingImagesCollection(Collection<TfindingImages> tfindingImagesCollection) {
        this.tfindingImagesCollection = tfindingImagesCollection;
    }

    @XmlTransient
    public Collection<TAnthropometry> getTAnthropometryCollection() {
        return tAnthropometryCollection;
    }

    public void setTAnthropometryCollection(Collection<TAnthropometry> tAnthropometryCollection) {
        this.tAnthropometryCollection = tAnthropometryCollection;
    }

    @XmlTransient
    public Collection<MChildAddress> getMChildAddressCollection() {
        return mChildAddressCollection;
    }

    public void setMChildAddressCollection(Collection<MChildAddress> mChildAddressCollection) {
        this.mChildAddressCollection = mChildAddressCollection;
    }

    @XmlTransient
    public Collection<MChildhistory> getMChildhistoryCollection() {
        return mChildhistoryCollection;
    }

    public void setMChildhistoryCollection(Collection<MChildhistory> mChildhistoryCollection) {
        this.mChildhistoryCollection = mChildhistoryCollection;
    }

    @XmlTransient
    public Collection<TChildacademy> getTChildacademyCollection() {
        return tChildacademyCollection;
    }

    public void setTChildacademyCollection(Collection<TChildacademy> tChildacademyCollection) {
        this.tChildacademyCollection = tChildacademyCollection;
    }

    @XmlTransient
    public Collection<TChiefcomplaints> getTChiefcomplaintsCollection() {
        return tChiefcomplaintsCollection;
    }

    public void setTChiefcomplaintsCollection(Collection<TChiefcomplaints> tChiefcomplaintsCollection) {
        this.tChiefcomplaintsCollection = tChiefcomplaintsCollection;
    }

    public TotherFindings getTotherFindings() {
        return totherFindings;
    }

    public void setTotherFindings(TotherFindings totherFindings) {
        this.totherFindings = totherFindings;
    }

    @XmlTransient
    public Collection<TScreentimelog> getTScreentimelogCollection() {
        return tScreentimelogCollection;
    }

    public void setTScreentimelogCollection(Collection<TScreentimelog> tScreentimelogCollection) {
        this.tScreentimelogCollection = tScreentimelogCollection;
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
        if (!(object instanceof MChild)) {
            return false;
        }
        MChild other = (MChild) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MChild[ id=" + id + " ]";
    }
    
}
