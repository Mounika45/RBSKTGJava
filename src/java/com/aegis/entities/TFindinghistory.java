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
@Table(name = "t_findinghistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TFindinghistory.findAll", query = "SELECT t FROM TFindinghistory t")
    , @NamedQuery(name = "TFindinghistory.findById", query = "SELECT t FROM TFindinghistory t WHERE t.id = :id")
    , @NamedQuery(name = "TFindinghistory.findByTranFindingId", query = "SELECT t FROM TFindinghistory t WHERE t.tranFindingId = :tranFindingId")
    , @NamedQuery(name = "TFindinghistory.findByFindingStatusId", query = "SELECT t FROM TFindinghistory t WHERE t.findingStatusId = :findingStatusId")
    , @NamedQuery(name = "TFindinghistory.findByCreatedUserId", query = "SELECT t FROM TFindinghistory t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TFindinghistory.findByCreatedOn", query = "SELECT t FROM TFindinghistory t WHERE t.createdOn = :createdOn")})
public class TFindinghistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TranFindingId")
    private int tranFindingId;
    @Basic(optional = false)
    @Column(name = "FindingStatusId")
    private int findingStatusId;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TFindinghistory() {
    }

    public TFindinghistory(Integer id) {
        this.id = id;
    }

    public TFindinghistory(Integer id, int tranFindingId, int findingStatusId) {
        this.id = id;
        this.tranFindingId = tranFindingId;
        this.findingStatusId = findingStatusId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTranFindingId() {
        return tranFindingId;
    }

    public void setTranFindingId(int tranFindingId) {
        this.tranFindingId = tranFindingId;
    }

    public int getFindingStatusId() {
        return findingStatusId;
    }

    public void setFindingStatusId(int findingStatusId) {
        this.findingStatusId = findingStatusId;
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
        if (!(object instanceof TFindinghistory)) {
            return false;
        }
        TFindinghistory other = (TFindinghistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TFindinghistory[ id=" + id + " ]";
    }
    
}
