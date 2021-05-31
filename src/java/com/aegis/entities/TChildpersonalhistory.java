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
@Table(name = "t_childpersonalhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TChildpersonalhistory.findAll", query = "SELECT t FROM TChildpersonalhistory t")
    , @NamedQuery(name = "TChildpersonalhistory.findById", query = "SELECT t FROM TChildpersonalhistory t WHERE t.id = :id")
    , @NamedQuery(name = "TChildpersonalhistory.findByAppetite", query = "SELECT t FROM TChildpersonalhistory t WHERE t.appetite = :appetite")
    , @NamedQuery(name = "TChildpersonalhistory.findByAppetiteRemarks", query = "SELECT t FROM TChildpersonalhistory t WHERE t.appetiteRemarks = :appetiteRemarks")
    , @NamedQuery(name = "TChildpersonalhistory.findBySleep", query = "SELECT t FROM TChildpersonalhistory t WHERE t.sleep = :sleep")
    , @NamedQuery(name = "TChildpersonalhistory.findBySleepRemarks", query = "SELECT t FROM TChildpersonalhistory t WHERE t.sleepRemarks = :sleepRemarks")
    , @NamedQuery(name = "TChildpersonalhistory.findByBladderandBowel", query = "SELECT t FROM TChildpersonalhistory t WHERE t.bladderandBowel = :bladderandBowel")
    , @NamedQuery(name = "TChildpersonalhistory.findByBladderandBowelRemarks", query = "SELECT t FROM TChildpersonalhistory t WHERE t.bladderandBowelRemarks = :bladderandBowelRemarks")
    , @NamedQuery(name = "TChildpersonalhistory.findByIsChildDifficult", query = "SELECT t FROM TChildpersonalhistory t WHERE t.isChildDifficult = :isChildDifficult")
    , @NamedQuery(name = "TChildpersonalhistory.findByDifficultChildRemarks", query = "SELECT t FROM TChildpersonalhistory t WHERE t.difficultChildRemarks = :difficultChildRemarks")
    , @NamedQuery(name = "TChildpersonalhistory.findByIsChildGoingOut", query = "SELECT t FROM TChildpersonalhistory t WHERE t.isChildGoingOut = :isChildGoingOut")
    , @NamedQuery(name = "TChildpersonalhistory.findByChildGoingOutRemarks", query = "SELECT t FROM TChildpersonalhistory t WHERE t.childGoingOutRemarks = :childGoingOutRemarks")
    , @NamedQuery(name = "TChildpersonalhistory.findByHasFoodAllergy", query = "SELECT t FROM TChildpersonalhistory t WHERE t.hasFoodAllergy = :hasFoodAllergy")
    , @NamedQuery(name = "TChildpersonalhistory.findByFoodRemarks", query = "SELECT t FROM TChildpersonalhistory t WHERE t.foodRemarks = :foodRemarks")
    , @NamedQuery(name = "TChildpersonalhistory.findByHasDrugAllergy", query = "SELECT t FROM TChildpersonalhistory t WHERE t.hasDrugAllergy = :hasDrugAllergy")
    , @NamedQuery(name = "TChildpersonalhistory.findByDrugRemarks", query = "SELECT t FROM TChildpersonalhistory t WHERE t.drugRemarks = :drugRemarks")
    , @NamedQuery(name = "TChildpersonalhistory.findByCreatedUserId", query = "SELECT t FROM TChildpersonalhistory t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TChildpersonalhistory.findByCreatedOn", query = "SELECT t FROM TChildpersonalhistory t WHERE t.createdOn = :createdOn")})
public class TChildpersonalhistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Appetite")
    private String appetite;
    @Column(name = "AppetiteRemarks")
    private String appetiteRemarks;
    @Column(name = "Sleep")
    private String sleep;
    @Column(name = "SleepRemarks")
    private String sleepRemarks;
    @Column(name = "BladderandBowel")
    private String bladderandBowel;
    @Column(name = "BladderandBowelRemarks")
    private String bladderandBowelRemarks;
    @Column(name = "IsChildDifficult")
    private Boolean isChildDifficult;
    @Column(name = "DifficultChildRemarks")
    private String difficultChildRemarks;
    @Column(name = "IsChildGoingOut")
    private Boolean isChildGoingOut;
    @Column(name = "ChildGoingOutRemarks")
    private String childGoingOutRemarks;
    @Column(name = "HasFoodAllergy")
    private Boolean hasFoodAllergy;
    @Column(name = "FoodRemarks")
    private String foodRemarks;
    @Column(name = "HasDrugAllergy")
    private Boolean hasDrugAllergy;
    @Column(name = "DrugRemarks")
    private String drugRemarks;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "ChildId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MChild childId;

    public TChildpersonalhistory() {
    }

    public TChildpersonalhistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppetite() {
        return appetite;
    }

    public void setAppetite(String appetite) {
        this.appetite = appetite;
    }

    public String getAppetiteRemarks() {
        return appetiteRemarks;
    }

    public void setAppetiteRemarks(String appetiteRemarks) {
        this.appetiteRemarks = appetiteRemarks;
    }

    public String getSleep() {
        return sleep;
    }

    public void setSleep(String sleep) {
        this.sleep = sleep;
    }

    public String getSleepRemarks() {
        return sleepRemarks;
    }

    public void setSleepRemarks(String sleepRemarks) {
        this.sleepRemarks = sleepRemarks;
    }

    public String getBladderandBowel() {
        return bladderandBowel;
    }

    public void setBladderandBowel(String bladderandBowel) {
        this.bladderandBowel = bladderandBowel;
    }

    public String getBladderandBowelRemarks() {
        return bladderandBowelRemarks;
    }

    public void setBladderandBowelRemarks(String bladderandBowelRemarks) {
        this.bladderandBowelRemarks = bladderandBowelRemarks;
    }

    public Boolean getIsChildDifficult() {
        return isChildDifficult;
    }

    public void setIsChildDifficult(Boolean isChildDifficult) {
        this.isChildDifficult = isChildDifficult;
    }

    public String getDifficultChildRemarks() {
        return difficultChildRemarks;
    }

    public void setDifficultChildRemarks(String difficultChildRemarks) {
        this.difficultChildRemarks = difficultChildRemarks;
    }

    public Boolean getIsChildGoingOut() {
        return isChildGoingOut;
    }

    public void setIsChildGoingOut(Boolean isChildGoingOut) {
        this.isChildGoingOut = isChildGoingOut;
    }

    public String getChildGoingOutRemarks() {
        return childGoingOutRemarks;
    }

    public void setChildGoingOutRemarks(String childGoingOutRemarks) {
        this.childGoingOutRemarks = childGoingOutRemarks;
    }

    public Boolean getHasFoodAllergy() {
        return hasFoodAllergy;
    }

    public void setHasFoodAllergy(Boolean hasFoodAllergy) {
        this.hasFoodAllergy = hasFoodAllergy;
    }

    public String getFoodRemarks() {
        return foodRemarks;
    }

    public void setFoodRemarks(String foodRemarks) {
        this.foodRemarks = foodRemarks;
    }

    public Boolean getHasDrugAllergy() {
        return hasDrugAllergy;
    }

    public void setHasDrugAllergy(Boolean hasDrugAllergy) {
        this.hasDrugAllergy = hasDrugAllergy;
    }

    public String getDrugRemarks() {
        return drugRemarks;
    }

    public void setDrugRemarks(String drugRemarks) {
        this.drugRemarks = drugRemarks;
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
        if (!(object instanceof TChildpersonalhistory)) {
            return false;
        }
        TChildpersonalhistory other = (TChildpersonalhistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TChildpersonalhistory[ id=" + id + " ]";
    }
    
}
