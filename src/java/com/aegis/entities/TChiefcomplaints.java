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
@Table(name = "t_chiefcomplaints")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TChiefcomplaints.findAll", query = "SELECT t FROM TChiefcomplaints t")
    , @NamedQuery(name = "TChiefcomplaints.findById", query = "SELECT t FROM TChiefcomplaints t WHERE t.id = :id")
    , @NamedQuery(name = "TChiefcomplaints.findByCreatedUserId", query = "SELECT t FROM TChiefcomplaints t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TChiefcomplaints.findByCreatedOn", query = "SELECT t FROM TChiefcomplaints t WHERE t.createdOn = :createdOn")})
public class TChiefcomplaints implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "ChiefComplaintId", referencedColumnName = "Id")
    @ManyToOne
    private MChiefcomplaints chiefComplaintId;
    @JoinColumn(name = "ChildId", referencedColumnName = "Id")
    @ManyToOne
    private MChild childId;

    public TChiefcomplaints() {
    }

    public TChiefcomplaints(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public MChiefcomplaints getChiefComplaintId() {
        return chiefComplaintId;
    }

    public void setChiefComplaintId(MChiefcomplaints chiefComplaintId) {
        this.chiefComplaintId = chiefComplaintId;
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
        if (!(object instanceof TChiefcomplaints)) {
            return false;
        }
        TChiefcomplaints other = (TChiefcomplaints) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TChiefcomplaints[ id=" + id + " ]";
    }
    
}
