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
@Table(name = "t_familyhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TFamilyhistory.findAll", query = "SELECT t FROM TFamilyhistory t")
    , @NamedQuery(name = "TFamilyhistory.findById", query = "SELECT t FROM TFamilyhistory t WHERE t.id = :id")
    , @NamedQuery(name = "TFamilyhistory.findByChildId", query = "SELECT t FROM TFamilyhistory t WHERE t.childId = :childId")
    , @NamedQuery(name = "TFamilyhistory.findByRelationship", query = "SELECT t FROM TFamilyhistory t WHERE t.relationship = :relationship")
    , @NamedQuery(name = "TFamilyhistory.findByIllnessID", query = "SELECT t FROM TFamilyhistory t WHERE t.illnessID = :illnessID")
    , @NamedQuery(name = "TFamilyhistory.findByCreatedUserID", query = "SELECT t FROM TFamilyhistory t WHERE t.createdUserID = :createdUserID")
    , @NamedQuery(name = "TFamilyhistory.findByCreatedOn", query = "SELECT t FROM TFamilyhistory t WHERE t.createdOn = :createdOn")
    , @NamedQuery(name = "TFamilyhistory.findByIsDeleted", query = "SELECT t FROM TFamilyhistory t WHERE t.isDeleted = :isDeleted")})
public class TFamilyhistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ChildId")
    private int childId;
    @Column(name = "Relationship")
    private String relationship;
    @Column(name = "IllnessID")
    private Integer illnessID;
    @Column(name = "CreatedUserID")
    private Integer createdUserID;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    public TFamilyhistory() {
    }

    public TFamilyhistory(Integer id) {
        this.id = id;
    }

    public TFamilyhistory(Integer id, int childId) {
        this.id = id;
        this.childId = childId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Integer getIllnessID() {
        return illnessID;
    }

    public void setIllnessID(Integer illnessID) {
        this.illnessID = illnessID;
    }

    public Integer getCreatedUserID() {
        return createdUserID;
    }

    public void setCreatedUserID(Integer createdUserID) {
        this.createdUserID = createdUserID;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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
        if (!(object instanceof TFamilyhistory)) {
            return false;
        }
        TFamilyhistory other = (TFamilyhistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TFamilyhistory[ id=" + id + " ]";
    }
    
}
