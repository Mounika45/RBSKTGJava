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
@Table(name = "t_confirmfindings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TConfirmfindings.findAll", query = "SELECT t FROM TConfirmfindings t")
    , @NamedQuery(name = "TConfirmfindings.findById", query = "SELECT t FROM TConfirmfindings t WHERE t.id = :id")
    , @NamedQuery(name = "TConfirmfindings.findByTranFindingID", query = "SELECT t FROM TConfirmfindings t WHERE t.tranFindingID = :tranFindingID")
    , @NamedQuery(name = "TConfirmfindings.findByConfirmation", query = "SELECT t FROM TConfirmfindings t WHERE t.confirmation = :confirmation")
    , @NamedQuery(name = "TConfirmfindings.findByRefferedTo", query = "SELECT t FROM TConfirmfindings t WHERE t.refferedTo = :refferedTo")
    , @NamedQuery(name = "TConfirmfindings.findByCreatedUserId", query = "SELECT t FROM TConfirmfindings t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TConfirmfindings.findByCreatedOn", query = "SELECT t FROM TConfirmfindings t WHERE t.createdOn = :createdOn")})
public class TConfirmfindings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TranFindingID")
    private Integer tranFindingID;
    @Column(name = "Confirmation")
    private Boolean confirmation;
    @Column(name = "RefferedTo")
    private String refferedTo;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "UserID", referencedColumnName = "Id")
    @ManyToOne
    private MUser userID;

    public TConfirmfindings() {
    }

    public TConfirmfindings(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTranFindingID() {
        return tranFindingID;
    }

    public void setTranFindingID(Integer tranFindingID) {
        this.tranFindingID = tranFindingID;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    public String getRefferedTo() {
        return refferedTo;
    }

    public void setRefferedTo(String refferedTo) {
        this.refferedTo = refferedTo;
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

    public MUser getUserID() {
        return userID;
    }

    public void setUserID(MUser userID) {
        this.userID = userID;
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
        if (!(object instanceof TConfirmfindings)) {
            return false;
        }
        TConfirmfindings other = (TConfirmfindings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TConfirmfindings[ id=" + id + " ]";
    }
    
}
