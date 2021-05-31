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
@Table(name = "t_diagnosis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDiagnosis.findAll", query = "SELECT t FROM TDiagnosis t")
    , @NamedQuery(name = "TDiagnosis.findById", query = "SELECT t FROM TDiagnosis t WHERE t.id = :id")
    , @NamedQuery(name = "TDiagnosis.findByChildId", query = "SELECT t FROM TDiagnosis t WHERE t.childId = :childId")
    , @NamedQuery(name = "TDiagnosis.findByTranFindingId", query = "SELECT t FROM TDiagnosis t WHERE t.tranFindingId = :tranFindingId")
    , @NamedQuery(name = "TDiagnosis.findByDiagnosis", query = "SELECT t FROM TDiagnosis t WHERE t.diagnosis = :diagnosis")
    , @NamedQuery(name = "TDiagnosis.findByPostTestDiagnosis", query = "SELECT t FROM TDiagnosis t WHERE t.postTestDiagnosis = :postTestDiagnosis")
    , @NamedQuery(name = "TDiagnosis.findByCreatedBy", query = "SELECT t FROM TDiagnosis t WHERE t.createdBy = :createdBy")
    , @NamedQuery(name = "TDiagnosis.findByCreatedOn", query = "SELECT t FROM TDiagnosis t WHERE t.createdOn = :createdOn")})
public class TDiagnosis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ChildId")
    private int childId;
    @Column(name = "TranFindingId")
    private Integer tranFindingId;
    @Column(name = "Diagnosis")
    private String diagnosis;
    @Column(name = "PostTestDiagnosis")
    private String postTestDiagnosis;
    @Column(name = "CreatedBy")
    private Integer createdBy;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TDiagnosis() {
    }

    public TDiagnosis(Integer id) {
        this.id = id;
    }

    public TDiagnosis(Integer id, int childId) {
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

    public Integer getTranFindingId() {
        return tranFindingId;
    }

    public void setTranFindingId(Integer tranFindingId) {
        this.tranFindingId = tranFindingId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPostTestDiagnosis() {
        return postTestDiagnosis;
    }

    public void setPostTestDiagnosis(String postTestDiagnosis) {
        this.postTestDiagnosis = postTestDiagnosis;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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
        if (!(object instanceof TDiagnosis)) {
            return false;
        }
        TDiagnosis other = (TDiagnosis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TDiagnosis[ id=" + id + " ]";
    }
    
}
