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
@Table(name = "m_school")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MSchool.findAll", query = "SELECT m FROM MSchool m")
    , @NamedQuery(name = "MSchool.findById", query = "SELECT m FROM MSchool m WHERE m.id = :id")
    , @NamedQuery(name = "MSchool.findByCode", query = "SELECT m FROM MSchool m WHERE m.code = :code")
    , @NamedQuery(name = "MSchool.findByName", query = "SELECT m FROM MSchool m WHERE m.name = :name")
    , @NamedQuery(name = "MSchool.findByDistrictId", query = "SELECT m FROM MSchool m WHERE m.districtId = :districtId")
    , @NamedQuery(name = "MSchool.findByMandalId", query = "SELECT m FROM MSchool m WHERE m.mandalId = :mandalId")
    , @NamedQuery(name = "MSchool.findByVillageId", query = "SELECT m FROM MSchool m WHERE m.villageId = :villageId")
    , @NamedQuery(name = "MSchool.findByLatitude", query = "SELECT m FROM MSchool m WHERE m.latitude = :latitude")
    , @NamedQuery(name = "MSchool.findByLongitude", query = "SELECT m FROM MSchool m WHERE m.longitude = :longitude")
    , @NamedQuery(name = "MSchool.findByImagePath", query = "SELECT m FROM MSchool m WHERE m.imagePath = :imagePath")
    , @NamedQuery(name = "MSchool.findByIsActive", query = "SELECT m FROM MSchool m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MSchool.findByCreatedUserId", query = "SELECT m FROM MSchool m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MSchool.findByCreatedOn", query = "SELECT m FROM MSchool m WHERE m.createdOn = :createdOn")})
public class MSchool implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "DistrictId")
    private int districtId;
    @Basic(optional = false)
    @Column(name = "MandalId")
    private int mandalId;
    @Basic(optional = false)
    @Column(name = "VillageId")
    private int villageId;
    @Column(name = "Latitude")
    private String latitude;
    @Column(name = "Longitude")
    private String longitude;
    @Column(name = "ImagePath")
    private String imagePath;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolId")
    private Collection<MChild> mChildCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolId")
    private Collection<MSchoolPrincipal> mSchoolPrincipalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolid")
    private Collection<TfindingImages> tfindingImagesCollection;
    @JoinColumn(name = "MediumId", referencedColumnName = "Id")
    @ManyToOne
    private MMedium mediumId;
    @JoinColumn(name = "CategoryId", referencedColumnName = "Id")
    @ManyToOne
    private MSchoolcategory categoryId;
    @OneToMany(mappedBy = "schoolID")
    private Collection<TChildacademy> tChildacademyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolid")
    private Collection<TotherFindings> totherFindingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolId")
    private Collection<TTeamschedule> tTeamscheduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolId")
    private Collection<TSchoolquestionanswer> tSchoolquestionanswerCollection;

    public MSchool() {
    }

    public MSchool(Integer id) {
        this.id = id;
    }

    public MSchool(Integer id, String code, String name, int districtId, int mandalId, int villageId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.districtId = districtId;
        this.mandalId = mandalId;
        this.villageId = villageId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getMandalId() {
        return mandalId;
    }

    public void setMandalId(int mandalId) {
        this.mandalId = mandalId;
    }

    public int getVillageId() {
        return villageId;
    }

    public void setVillageId(int villageId) {
        this.villageId = villageId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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

    @XmlTransient
    public Collection<MChild> getMChildCollection() {
        return mChildCollection;
    }

    public void setMChildCollection(Collection<MChild> mChildCollection) {
        this.mChildCollection = mChildCollection;
    }

    @XmlTransient
    public Collection<MSchoolPrincipal> getMSchoolPrincipalCollection() {
        return mSchoolPrincipalCollection;
    }

    public void setMSchoolPrincipalCollection(Collection<MSchoolPrincipal> mSchoolPrincipalCollection) {
        this.mSchoolPrincipalCollection = mSchoolPrincipalCollection;
    }

    @XmlTransient
    public Collection<TfindingImages> getTfindingImagesCollection() {
        return tfindingImagesCollection;
    }

    public void setTfindingImagesCollection(Collection<TfindingImages> tfindingImagesCollection) {
        this.tfindingImagesCollection = tfindingImagesCollection;
    }

    public MMedium getMediumId() {
        return mediumId;
    }

    public void setMediumId(MMedium mediumId) {
        this.mediumId = mediumId;
    }

    public MSchoolcategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(MSchoolcategory categoryId) {
        this.categoryId = categoryId;
    }

    @XmlTransient
    public Collection<TChildacademy> getTChildacademyCollection() {
        return tChildacademyCollection;
    }

    public void setTChildacademyCollection(Collection<TChildacademy> tChildacademyCollection) {
        this.tChildacademyCollection = tChildacademyCollection;
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
    public Collection<TSchoolquestionanswer> getTSchoolquestionanswerCollection() {
        return tSchoolquestionanswerCollection;
    }

    public void setTSchoolquestionanswerCollection(Collection<TSchoolquestionanswer> tSchoolquestionanswerCollection) {
        this.tSchoolquestionanswerCollection = tSchoolquestionanswerCollection;
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
        if (!(object instanceof MSchool)) {
            return false;
        }
        MSchool other = (MSchool) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MSchool[ id=" + id + " ]";
    }
    
}
