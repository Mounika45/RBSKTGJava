/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "t_generalphysicalexamination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TGeneralphysicalexamination.findAll", query = "SELECT t FROM TGeneralphysicalexamination t")
    , @NamedQuery(name = "TGeneralphysicalexamination.findById", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.id = :id")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByChildId", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.childId = :childId")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByPallor", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.pallor = :pallor")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByPallorRemarks", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.pallorRemarks = :pallorRemarks")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByIcterus", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.icterus = :icterus")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByIcterusRemarks", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.icterusRemarks = :icterusRemarks")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByClubbing", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.clubbing = :clubbing")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByClubbingRemarks", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.clubbingRemarks = :clubbingRemarks")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByKoilonychia", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.koilonychia = :koilonychia")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByKoilonychiaRemarks", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.koilonychiaRemarks = :koilonychiaRemarks")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByLymphadenopathy", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.lymphadenopathy = :lymphadenopathy")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByLymphadenopathyRemarks", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.lymphadenopathyRemarks = :lymphadenopathyRemarks")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByPedalEdena", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.pedalEdena = :pedalEdena")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByPedalEdenaRemarks", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.pedalEdenaRemarks = :pedalEdenaRemarks")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByPulseRate", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.pulseRate = :pulseRate")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByRespiratoryRate", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.respiratoryRate = :respiratoryRate")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByCreatedUserId", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TGeneralphysicalexamination.findByCreatedOn", query = "SELECT t FROM TGeneralphysicalexamination t WHERE t.createdOn = :createdOn")})
public class TGeneralphysicalexamination implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ChildId")
    private int childId;
    @Column(name = "Pallor")
    private Boolean pallor;
    @Column(name = "PallorRemarks")
    private String pallorRemarks;
    @Column(name = "Icterus")
    private Boolean icterus;
    @Column(name = "IcterusRemarks")
    private String icterusRemarks;
    @Column(name = "Clubbing")
    private Boolean clubbing;
    @Column(name = "ClubbingRemarks")
    private String clubbingRemarks;
    @Column(name = "Koilonychia")
    private Boolean koilonychia;
    @Column(name = "KoilonychiaRemarks")
    private String koilonychiaRemarks;
    @Column(name = "Lymphadenopathy")
    private Boolean lymphadenopathy;
    @Column(name = "LymphadenopathyRemarks")
    private String lymphadenopathyRemarks;
    @Column(name = "PedalEdena")
    private Boolean pedalEdena;
    @Column(name = "PedalEdenaRemarks")
    private String pedalEdenaRemarks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PulseRate")
    private BigDecimal pulseRate;
    @Column(name = "RespiratoryRate")
    private BigDecimal respiratoryRate;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TGeneralphysicalexamination() {
    }

    public TGeneralphysicalexamination(Integer id) {
        this.id = id;
    }

    public TGeneralphysicalexamination(Integer id, int childId) {
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

    public Boolean getPallor() {
        return pallor;
    }

    public void setPallor(Boolean pallor) {
        this.pallor = pallor;
    }

    public String getPallorRemarks() {
        return pallorRemarks;
    }

    public void setPallorRemarks(String pallorRemarks) {
        this.pallorRemarks = pallorRemarks;
    }

    public Boolean getIcterus() {
        return icterus;
    }

    public void setIcterus(Boolean icterus) {
        this.icterus = icterus;
    }

    public String getIcterusRemarks() {
        return icterusRemarks;
    }

    public void setIcterusRemarks(String icterusRemarks) {
        this.icterusRemarks = icterusRemarks;
    }

    public Boolean getClubbing() {
        return clubbing;
    }

    public void setClubbing(Boolean clubbing) {
        this.clubbing = clubbing;
    }

    public String getClubbingRemarks() {
        return clubbingRemarks;
    }

    public void setClubbingRemarks(String clubbingRemarks) {
        this.clubbingRemarks = clubbingRemarks;
    }

    public Boolean getKoilonychia() {
        return koilonychia;
    }

    public void setKoilonychia(Boolean koilonychia) {
        this.koilonychia = koilonychia;
    }

    public String getKoilonychiaRemarks() {
        return koilonychiaRemarks;
    }

    public void setKoilonychiaRemarks(String koilonychiaRemarks) {
        this.koilonychiaRemarks = koilonychiaRemarks;
    }

    public Boolean getLymphadenopathy() {
        return lymphadenopathy;
    }

    public void setLymphadenopathy(Boolean lymphadenopathy) {
        this.lymphadenopathy = lymphadenopathy;
    }

    public String getLymphadenopathyRemarks() {
        return lymphadenopathyRemarks;
    }

    public void setLymphadenopathyRemarks(String lymphadenopathyRemarks) {
        this.lymphadenopathyRemarks = lymphadenopathyRemarks;
    }

    public Boolean getPedalEdena() {
        return pedalEdena;
    }

    public void setPedalEdena(Boolean pedalEdena) {
        this.pedalEdena = pedalEdena;
    }

    public String getPedalEdenaRemarks() {
        return pedalEdenaRemarks;
    }

    public void setPedalEdenaRemarks(String pedalEdenaRemarks) {
        this.pedalEdenaRemarks = pedalEdenaRemarks;
    }

    public BigDecimal getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(BigDecimal pulseRate) {
        this.pulseRate = pulseRate;
    }

    public BigDecimal getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(BigDecimal respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
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
        if (!(object instanceof TGeneralphysicalexamination)) {
            return false;
        }
        TGeneralphysicalexamination other = (TGeneralphysicalexamination) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TGeneralphysicalexamination[ id=" + id + " ]";
    }
    
}
