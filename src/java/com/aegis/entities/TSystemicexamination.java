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
@Table(name = "t_systemicexamination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSystemicexamination.findAll", query = "SELECT t FROM TSystemicexamination t")
    , @NamedQuery(name = "TSystemicexamination.findById", query = "SELECT t FROM TSystemicexamination t WHERE t.id = :id")
    , @NamedQuery(name = "TSystemicexamination.findByChildId", query = "SELECT t FROM TSystemicexamination t WHERE t.childId = :childId")
    , @NamedQuery(name = "TSystemicexamination.findByRespiratory", query = "SELECT t FROM TSystemicexamination t WHERE t.respiratory = :respiratory")
    , @NamedQuery(name = "TSystemicexamination.findByCns", query = "SELECT t FROM TSystemicexamination t WHERE t.cns = :cns")
    , @NamedQuery(name = "TSystemicexamination.findByCardiovascular", query = "SELECT t FROM TSystemicexamination t WHERE t.cardiovascular = :cardiovascular")
    , @NamedQuery(name = "TSystemicexamination.findByGit", query = "SELECT t FROM TSystemicexamination t WHERE t.git = :git")
    , @NamedQuery(name = "TSystemicexamination.findByOthers", query = "SELECT t FROM TSystemicexamination t WHERE t.others = :others")
    , @NamedQuery(name = "TSystemicexamination.findByCreatedUserId", query = "SELECT t FROM TSystemicexamination t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TSystemicexamination.findByCreatedOn", query = "SELECT t FROM TSystemicexamination t WHERE t.createdOn = :createdOn")})
public class TSystemicexamination implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ChildId")
    private int childId;
    @Column(name = "Respiratory")
    private String respiratory;
    @Column(name = "CNS")
    private String cns;
    @Column(name = "Cardiovascular")
    private String cardiovascular;
    @Column(name = "GIT")
    private String git;
    @Column(name = "Others")
    private String others;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TSystemicexamination() {
    }

    public TSystemicexamination(Integer id) {
        this.id = id;
    }

    public TSystemicexamination(Integer id, int childId) {
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

    public String getRespiratory() {
        return respiratory;
    }

    public void setRespiratory(String respiratory) {
        this.respiratory = respiratory;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getCardiovascular() {
        return cardiovascular;
    }

    public void setCardiovascular(String cardiovascular) {
        this.cardiovascular = cardiovascular;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
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
        if (!(object instanceof TSystemicexamination)) {
            return false;
        }
        TSystemicexamination other = (TSystemicexamination) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TSystemicexamination[ id=" + id + " ]";
    }
    
}
