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
@Table(name = "t_symptom_finding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSymptomFinding.findAll", query = "SELECT t FROM TSymptomFinding t")
    , @NamedQuery(name = "TSymptomFinding.findById", query = "SELECT t FROM TSymptomFinding t WHERE t.id = :id")
    , @NamedQuery(name = "TSymptomFinding.findByCreatedUserId", query = "SELECT t FROM TSymptomFinding t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TSymptomFinding.findByCreatedOn", query = "SELECT t FROM TSymptomFinding t WHERE t.createdOn = :createdOn")})
public class TSymptomFinding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "FindingId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MFinding findingId;
    @JoinColumn(name = "SymptomId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MSymptom symptomId;

    public TSymptomFinding() {
    }

    public TSymptomFinding(Integer id) {
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

    public MFinding getFindingId() {
        return findingId;
    }

    public void setFindingId(MFinding findingId) {
        this.findingId = findingId;
    }

    public MSymptom getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(MSymptom symptomId) {
        this.symptomId = symptomId;
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
        if (!(object instanceof TSymptomFinding)) {
            return false;
        }
        TSymptomFinding other = (TSymptomFinding) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TSymptomFinding[ id=" + id + " ]";
    }
    
}
