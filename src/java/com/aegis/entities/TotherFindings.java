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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "t_otherFindings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TotherFindings.findAll", query = "SELECT t FROM TotherFindings t")
    , @NamedQuery(name = "TotherFindings.findById", query = "SELECT t FROM TotherFindings t WHERE t.id = :id")
    , @NamedQuery(name = "TotherFindings.findByChildid", query = "SELECT t FROM TotherFindings t WHERE t.childid = :childid")
    , @NamedQuery(name = "TotherFindings.findByDescription", query = "SELECT t FROM TotherFindings t WHERE t.description = :description")
    , @NamedQuery(name = "TotherFindings.findByFilepath", query = "SELECT t FROM TotherFindings t WHERE t.filepath = :filepath")
    , @NamedQuery(name = "TotherFindings.findByDeficiency", query = "SELECT t FROM TotherFindings t WHERE t.deficiency = :deficiency")
    , @NamedQuery(name = "TotherFindings.findByCreateddate", query = "SELECT t FROM TotherFindings t WHERE t.createddate = :createddate")})
public class TotherFindings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "childid")
    private String childid;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "filepath")
    private String filepath;
    @Basic(optional = false)
    @Column(name = "deficiency")
    private String deficiency;
    @Basic(optional = false)
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @JoinColumn(name = "id", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MChild mChild;
    @JoinColumn(name = "schoolid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MSchool schoolid;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MUser createdUserId;

    public TotherFindings() {
    }

    public TotherFindings(Integer id) {
        this.id = id;
    }

    public TotherFindings(Integer id, String childid, String description, String filepath, String deficiency, Date createddate) {
        this.id = id;
        this.childid = childid;
        this.description = description;
        this.filepath = filepath;
        this.deficiency = deficiency;
        this.createddate = createddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChildid() {
        return childid;
    }

    public void setChildid(String childid) {
        this.childid = childid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getDeficiency() {
        return deficiency;
    }

    public void setDeficiency(String deficiency) {
        this.deficiency = deficiency;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public MChild getMChild() {
        return mChild;
    }

    public void setMChild(MChild mChild) {
        this.mChild = mChild;
    }

    public MSchool getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(MSchool schoolid) {
        this.schoolid = schoolid;
    }

    public MUser getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(MUser createdUserId) {
        this.createdUserId = createdUserId;
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
        if (!(object instanceof TotherFindings)) {
            return false;
        }
        TotherFindings other = (TotherFindings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TotherFindings[ id=" + id + " ]";
    }
    
}
