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
@Table(name = "t_illness")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TIllness.findAll", query = "SELECT t FROM TIllness t")
    , @NamedQuery(name = "TIllness.findById", query = "SELECT t FROM TIllness t WHERE t.id = :id")
    , @NamedQuery(name = "TIllness.findByChildId", query = "SELECT t FROM TIllness t WHERE t.childId = :childId")
    , @NamedQuery(name = "TIllness.findByIllnessId", query = "SELECT t FROM TIllness t WHERE t.illnessId = :illnessId")
    , @NamedQuery(name = "TIllness.findByCreatedUserId", query = "SELECT t FROM TIllness t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TIllness.findByCreatedOn", query = "SELECT t FROM TIllness t WHERE t.createdOn = :createdOn")})
public class TIllness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ChildId")
    private int childId;
    @Column(name = "IllnessId")
    private Integer illnessId;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TIllness() {
    }

    public TIllness(Integer id) {
        this.id = id;
    }

    public TIllness(Integer id, int childId) {
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

    public Integer getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(Integer illnessId) {
        this.illnessId = illnessId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TIllness)) {
            return false;
        }
        TIllness other = (TIllness) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TIllness[ id=" + id + " ]";
    }
    
}
