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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "m_agegroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MAgegroup.findAll", query = "SELECT m FROM MAgegroup m")
    , @NamedQuery(name = "MAgegroup.findById", query = "SELECT m FROM MAgegroup m WHERE m.id = :id")
    , @NamedQuery(name = "MAgegroup.findByName", query = "SELECT m FROM MAgegroup m WHERE m.name = :name")
    , @NamedQuery(name = "MAgegroup.findByCreatedOn", query = "SELECT m FROM MAgegroup m WHERE m.createdOn = :createdOn")})
public class MAgegroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToMany(mappedBy = "ageGroupId")
    private Collection<MSymptom> mSymptomCollection;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "Id")
    @ManyToOne
    private MUser createdUserId;

    public MAgegroup() {
    }

    public MAgegroup(Integer id) {
        this.id = id;
    }

    public MAgegroup(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @XmlTransient
    public Collection<MSymptom> getMSymptomCollection() {
        return mSymptomCollection;
    }

    public void setMSymptomCollection(Collection<MSymptom> mSymptomCollection) {
        this.mSymptomCollection = mSymptomCollection;
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
        if (!(object instanceof MAgegroup)) {
            return false;
        }
        MAgegroup other = (MAgegroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MAgegroup[ id=" + id + " ]";
    }
    
}
