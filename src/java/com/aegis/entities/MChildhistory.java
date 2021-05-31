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
@Table(name = "m_childhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MChildhistory.findAll", query = "SELECT m FROM MChildhistory m")
    , @NamedQuery(name = "MChildhistory.findById", query = "SELECT m FROM MChildhistory m WHERE m.id = :id")
    , @NamedQuery(name = "MChildhistory.findByRegularChekup", query = "SELECT m FROM MChildhistory m WHERE m.regularChekup = :regularChekup")
    , @NamedQuery(name = "MChildhistory.findByRegularCheckUpRemarks", query = "SELECT m FROM MChildhistory m WHERE m.regularCheckUpRemarks = :regularCheckUpRemarks")
    , @NamedQuery(name = "MChildhistory.findByRecievedImmunization", query = "SELECT m FROM MChildhistory m WHERE m.recievedImmunization = :recievedImmunization")
    , @NamedQuery(name = "MChildhistory.findByRecievedImmunizationRemarks", query = "SELECT m FROM MChildhistory m WHERE m.recievedImmunizationRemarks = :recievedImmunizationRemarks")
    , @NamedQuery(name = "MChildhistory.findByIllnessDuringPregnancy", query = "SELECT m FROM MChildhistory m WHERE m.illnessDuringPregnancy = :illnessDuringPregnancy")
    , @NamedQuery(name = "MChildhistory.findByIllnessDuringPregnancyRemarks", query = "SELECT m FROM MChildhistory m WHERE m.illnessDuringPregnancyRemarks = :illnessDuringPregnancyRemarks")
    , @NamedQuery(name = "MChildhistory.findByReceivedIFA", query = "SELECT m FROM MChildhistory m WHERE m.receivedIFA = :receivedIFA")
    , @NamedQuery(name = "MChildhistory.findByReceivedIFARemarks", query = "SELECT m FROM MChildhistory m WHERE m.receivedIFARemarks = :receivedIFARemarks")
    , @NamedQuery(name = "MChildhistory.findByTypeofDelivery", query = "SELECT m FROM MChildhistory m WHERE m.typeofDelivery = :typeofDelivery")
    , @NamedQuery(name = "MChildhistory.findByPlaceofDelivery", query = "SELECT m FROM MChildhistory m WHERE m.placeofDelivery = :placeofDelivery")
    , @NamedQuery(name = "MChildhistory.findByOtherPlaceofDelivery", query = "SELECT m FROM MChildhistory m WHERE m.otherPlaceofDelivery = :otherPlaceofDelivery")
    , @NamedQuery(name = "MChildhistory.findByBirthWeight", query = "SELECT m FROM MChildhistory m WHERE m.birthWeight = :birthWeight")
    , @NamedQuery(name = "MChildhistory.findByCriedAfterBirth", query = "SELECT m FROM MChildhistory m WHERE m.criedAfterBirth = :criedAfterBirth")
    , @NamedQuery(name = "MChildhistory.findByAnyIllnessDuringPostNatal", query = "SELECT m FROM MChildhistory m WHERE m.anyIllnessDuringPostNatal = :anyIllnessDuringPostNatal")
    , @NamedQuery(name = "MChildhistory.findByPostNatalIllnessRemarks", query = "SELECT m FROM MChildhistory m WHERE m.postNatalIllnessRemarks = :postNatalIllnessRemarks")
    , @NamedQuery(name = "MChildhistory.findByAdmissionToNICU", query = "SELECT m FROM MChildhistory m WHERE m.admissionToNICU = :admissionToNICU")
    , @NamedQuery(name = "MChildhistory.findByAdmissionToNICURemarks", query = "SELECT m FROM MChildhistory m WHERE m.admissionToNICURemarks = :admissionToNICURemarks")
    , @NamedQuery(name = "MChildhistory.findByCreatedUserId", query = "SELECT m FROM MChildhistory m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MChildhistory.findByCreatedOn", query = "SELECT m FROM MChildhistory m WHERE m.createdOn = :createdOn")})
public class MChildhistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "RegularChekup")
    private Boolean regularChekup;
    @Column(name = "RegularCheckUpRemarks")
    private String regularCheckUpRemarks;
    @Column(name = "RecievedImmunization")
    private Boolean recievedImmunization;
    @Column(name = "RecievedImmunizationRemarks")
    private String recievedImmunizationRemarks;
    @Column(name = "IllnessDuringPregnancy")
    private Boolean illnessDuringPregnancy;
    @Column(name = "IllnessDuringPregnancyRemarks")
    private String illnessDuringPregnancyRemarks;
    @Column(name = "ReceivedIFA")
    private Boolean receivedIFA;
    @Column(name = "ReceivedIFARemarks")
    private String receivedIFARemarks;
    @Column(name = "TypeofDelivery")
    private String typeofDelivery;
    @Column(name = "PlaceofDelivery")
    private String placeofDelivery;
    @Column(name = "OtherPlaceofDelivery")
    private String otherPlaceofDelivery;
    @Column(name = "BirthWeight")
    private String birthWeight;
    @Column(name = "CriedAfterBirth")
    private String criedAfterBirth;
    @Column(name = "AnyIllnessDuringPostNatal")
    private Boolean anyIllnessDuringPostNatal;
    @Column(name = "PostNatalIllnessRemarks")
    private String postNatalIllnessRemarks;
    @Column(name = "AdmissionToNICU")
    private Boolean admissionToNICU;
    @Column(name = "AdmissionToNICURemarks")
    private String admissionToNICURemarks;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "ChildId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MChild childId;

    public MChildhistory() {
    }

    public MChildhistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getRegularChekup() {
        return regularChekup;
    }

    public void setRegularChekup(Boolean regularChekup) {
        this.regularChekup = regularChekup;
    }

    public String getRegularCheckUpRemarks() {
        return regularCheckUpRemarks;
    }

    public void setRegularCheckUpRemarks(String regularCheckUpRemarks) {
        this.regularCheckUpRemarks = regularCheckUpRemarks;
    }

    public Boolean getRecievedImmunization() {
        return recievedImmunization;
    }

    public void setRecievedImmunization(Boolean recievedImmunization) {
        this.recievedImmunization = recievedImmunization;
    }

    public String getRecievedImmunizationRemarks() {
        return recievedImmunizationRemarks;
    }

    public void setRecievedImmunizationRemarks(String recievedImmunizationRemarks) {
        this.recievedImmunizationRemarks = recievedImmunizationRemarks;
    }

    public Boolean getIllnessDuringPregnancy() {
        return illnessDuringPregnancy;
    }

    public void setIllnessDuringPregnancy(Boolean illnessDuringPregnancy) {
        this.illnessDuringPregnancy = illnessDuringPregnancy;
    }

    public String getIllnessDuringPregnancyRemarks() {
        return illnessDuringPregnancyRemarks;
    }

    public void setIllnessDuringPregnancyRemarks(String illnessDuringPregnancyRemarks) {
        this.illnessDuringPregnancyRemarks = illnessDuringPregnancyRemarks;
    }

    public Boolean getReceivedIFA() {
        return receivedIFA;
    }

    public void setReceivedIFA(Boolean receivedIFA) {
        this.receivedIFA = receivedIFA;
    }

    public String getReceivedIFARemarks() {
        return receivedIFARemarks;
    }

    public void setReceivedIFARemarks(String receivedIFARemarks) {
        this.receivedIFARemarks = receivedIFARemarks;
    }

    public String getTypeofDelivery() {
        return typeofDelivery;
    }

    public void setTypeofDelivery(String typeofDelivery) {
        this.typeofDelivery = typeofDelivery;
    }

    public String getPlaceofDelivery() {
        return placeofDelivery;
    }

    public void setPlaceofDelivery(String placeofDelivery) {
        this.placeofDelivery = placeofDelivery;
    }

    public String getOtherPlaceofDelivery() {
        return otherPlaceofDelivery;
    }

    public void setOtherPlaceofDelivery(String otherPlaceofDelivery) {
        this.otherPlaceofDelivery = otherPlaceofDelivery;
    }

    public String getBirthWeight() {
        return birthWeight;
    }

    public void setBirthWeight(String birthWeight) {
        this.birthWeight = birthWeight;
    }

    public String getCriedAfterBirth() {
        return criedAfterBirth;
    }

    public void setCriedAfterBirth(String criedAfterBirth) {
        this.criedAfterBirth = criedAfterBirth;
    }

    public Boolean getAnyIllnessDuringPostNatal() {
        return anyIllnessDuringPostNatal;
    }

    public void setAnyIllnessDuringPostNatal(Boolean anyIllnessDuringPostNatal) {
        this.anyIllnessDuringPostNatal = anyIllnessDuringPostNatal;
    }

    public String getPostNatalIllnessRemarks() {
        return postNatalIllnessRemarks;
    }

    public void setPostNatalIllnessRemarks(String postNatalIllnessRemarks) {
        this.postNatalIllnessRemarks = postNatalIllnessRemarks;
    }

    public Boolean getAdmissionToNICU() {
        return admissionToNICU;
    }

    public void setAdmissionToNICU(Boolean admissionToNICU) {
        this.admissionToNICU = admissionToNICU;
    }

    public String getAdmissionToNICURemarks() {
        return admissionToNICURemarks;
    }

    public void setAdmissionToNICURemarks(String admissionToNICURemarks) {
        this.admissionToNICURemarks = admissionToNICURemarks;
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

    public MChild getChildId() {
        return childId;
    }

    public void setChildId(MChild childId) {
        this.childId = childId;
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
        if (!(object instanceof MChildhistory)) {
            return false;
        }
        MChildhistory other = (MChildhistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MChildhistory[ id=" + id + " ]";
    }
    
}
