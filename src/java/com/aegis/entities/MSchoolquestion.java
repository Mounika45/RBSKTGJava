/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "m_schoolquestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MSchoolquestion.findAll", query = "SELECT m FROM MSchoolquestion m")
    , @NamedQuery(name = "MSchoolquestion.findById", query = "SELECT m FROM MSchoolquestion m WHERE m.id = :id")
    , @NamedQuery(name = "MSchoolquestion.findByName", query = "SELECT m FROM MSchoolquestion m WHERE m.name = :name")
    , @NamedQuery(name = "MSchoolquestion.findByIsActive", query = "SELECT m FROM MSchoolquestion m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MSchoolquestion.findByCreatedUserId", query = "SELECT m FROM MSchoolquestion m WHERE m.createdUserId = :createdUserId")
    , @NamedQuery(name = "MSchoolquestion.findByCreatedOn", query = "SELECT m FROM MSchoolquestion m WHERE m.createdOn = :createdOn")})
public class MSchoolquestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private Collection<TSchoolquestionanswer> tSchoolquestionanswerCollection;

    public MSchoolquestion() {
    }

    public MSchoolquestion(Integer id) {
        this.id = id;
    }

    public MSchoolquestion(Integer id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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

    @XmlTransient
    public Collection<TSchoolquestionanswer> getTSchoolquestionanswerCollection() {
        return tSchoolquestionanswerCollection;
    }

    public void setTSchoolquestionanswerCollection(Collection<TSchoolquestionanswer> tSchoolquestionanswerCollection) {
        this.tSchoolquestionanswerCollection = tSchoolquestionanswerCollection;
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
        if (!(object instanceof MSchoolquestion)) {
            return false;
        }
        MSchoolquestion other = (MSchoolquestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MSchoolquestion[ id=" + id + " ]";
    }
    
}
