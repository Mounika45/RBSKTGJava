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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "m_finding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MFinding.findAll", query = "SELECT m FROM MFinding m")
    , @NamedQuery(name = "MFinding.findById", query = "SELECT m FROM MFinding m WHERE m.id = :id")
    , @NamedQuery(name = "MFinding.findByCode", query = "SELECT m FROM MFinding m WHERE m.code = :code")
    , @NamedQuery(name = "MFinding.findByName", query = "SELECT m FROM MFinding m WHERE m.name = :name")
    , @NamedQuery(name = "MFinding.findByHasServiceTreatmentId", query = "SELECT m FROM MFinding m WHERE m.hasServiceTreatmentId = :hasServiceTreatmentId")
    , @NamedQuery(name = "MFinding.findByCreatedOn", query = "SELECT m FROM MFinding m WHERE m.createdOn = :createdOn")})
public class MFinding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "HasServiceTreatmentId")
    private boolean hasServiceTreatmentId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "findingid")
    private Collection<TfindingImages> tfindingImagesCollection;
    @JoinColumn(name = "PreliminaryId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MPreliminary preliminaryId;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "Id")
    @ManyToOne
    private MUser createdUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "findingId")
    private Collection<TSymptomFinding> tSymptomFindingCollection;

    public MFinding() {
    }

    public MFinding(Integer id) {
        this.id = id;
    }

    public MFinding(Integer id, String code, String name, boolean hasServiceTreatmentId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.hasServiceTreatmentId = hasServiceTreatmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getHasServiceTreatmentId() {
        return hasServiceTreatmentId;
    }

    public void setHasServiceTreatmentId(boolean hasServiceTreatmentId) {
        this.hasServiceTreatmentId = hasServiceTreatmentId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @XmlTransient
    public Collection<TfindingImages> getTfindingImagesCollection() {
        return tfindingImagesCollection;
    }

    public void setTfindingImagesCollection(Collection<TfindingImages> tfindingImagesCollection) {
        this.tfindingImagesCollection = tfindingImagesCollection;
    }

    public MPreliminary getPreliminaryId() {
        return preliminaryId;
    }

    public void setPreliminaryId(MPreliminary preliminaryId) {
        this.preliminaryId = preliminaryId;
    }

    public MUser getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(MUser createdUserId) {
        this.createdUserId = createdUserId;
    }

    @XmlTransient
    public Collection<TSymptomFinding> getTSymptomFindingCollection() {
        return tSymptomFindingCollection;
    }

    public void setTSymptomFindingCollection(Collection<TSymptomFinding> tSymptomFindingCollection) {
        this.tSymptomFindingCollection = tSymptomFindingCollection;
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
        if (!(object instanceof MFinding)) {
            return false;
        }
        MFinding other = (MFinding) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MFinding[ id=" + id + " ]";
    }
    
}
