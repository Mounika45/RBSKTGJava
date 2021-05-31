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
@Table(name = "t_findingImages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TfindingImages.findAll", query = "SELECT t FROM TfindingImages t")
    , @NamedQuery(name = "TfindingImages.findById", query = "SELECT t FROM TfindingImages t WHERE t.id = :id")
    , @NamedQuery(name = "TfindingImages.findByTranfindingid", query = "SELECT t FROM TfindingImages t WHERE t.tranfindingid = :tranfindingid")
    , @NamedQuery(name = "TfindingImages.findByFilepath", query = "SELECT t FROM TfindingImages t WHERE t.filepath = :filepath")
    , @NamedQuery(name = "TfindingImages.findByStatus", query = "SELECT t FROM TfindingImages t WHERE t.status = :status")
    , @NamedQuery(name = "TfindingImages.findByCreateddate", query = "SELECT t FROM TfindingImages t WHERE t.createddate = :createddate")})
public class TfindingImages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tranfindingid")
    private Integer tranfindingid;
    @Basic(optional = false)
    @Column(name = "filepath")
    private String filepath;
    @Basic(optional = false)
    @Column(name = "Status")
    private String status;
    @Basic(optional = false)
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @JoinColumn(name = "childid", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MChild childid;
    @JoinColumn(name = "findingid", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MFinding findingid;
    @JoinColumn(name = "schoolid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MSchool schoolid;

    public TfindingImages() {
    }

    public TfindingImages(Integer id) {
        this.id = id;
    }

    public TfindingImages(Integer id, String filepath, String status, Date createddate) {
        this.id = id;
        this.filepath = filepath;
        this.status = status;
        this.createddate = createddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTranfindingid() {
        return tranfindingid;
    }

    public void setTranfindingid(Integer tranfindingid) {
        this.tranfindingid = tranfindingid;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public MChild getChildid() {
        return childid;
    }

    public void setChildid(MChild childid) {
        this.childid = childid;
    }

    public MFinding getFindingid() {
        return findingid;
    }

    public void setFindingid(MFinding findingid) {
        this.findingid = findingid;
    }

    public MSchool getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(MSchool schoolid) {
        this.schoolid = schoolid;
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
        if (!(object instanceof TfindingImages)) {
            return false;
        }
        TfindingImages other = (TfindingImages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TfindingImages[ id=" + id + " ]";
    }
    
}
