/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "t_dentalcauses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDentalcauses.findAll", query = "SELECT t FROM TDentalcauses t")
    , @NamedQuery(name = "TDentalcauses.findById", query = "SELECT t FROM TDentalcauses t WHERE t.id = :id")
    , @NamedQuery(name = "TDentalcauses.findByOralExaminationId", query = "SELECT t FROM TDentalcauses t WHERE t.oralExaminationId = :oralExaminationId")
    , @NamedQuery(name = "TDentalcauses.findByCauseId", query = "SELECT t FROM TDentalcauses t WHERE t.causeId = :causeId")
    , @NamedQuery(name = "TDentalcauses.findByCreatedUserId", query = "SELECT t FROM TDentalcauses t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TDentalcauses.findByCreatedOn", query = "SELECT t FROM TDentalcauses t WHERE t.createdOn = :createdOn")})
public class TDentalcauses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "OralExaminationId")
    private Integer oralExaminationId;
    @Column(name = "CauseId")
    private Integer causeId;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tDentalcauses1")
    private TDentalcauses tDentalcauses;
    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TDentalcauses tDentalcauses1;

    public TDentalcauses() {
    }

    public TDentalcauses(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOralExaminationId() {
        return oralExaminationId;
    }

    public void setOralExaminationId(Integer oralExaminationId) {
        this.oralExaminationId = oralExaminationId;
    }

    public Integer getCauseId() {
        return causeId;
    }

    public void setCauseId(Integer causeId) {
        this.causeId = causeId;
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

    public TDentalcauses getTDentalcauses() {
        return tDentalcauses;
    }

    public void setTDentalcauses(TDentalcauses tDentalcauses) {
        this.tDentalcauses = tDentalcauses;
    }

    public TDentalcauses getTDentalcauses1() {
        return tDentalcauses1;
    }

    public void setTDentalcauses1(TDentalcauses tDentalcauses1) {
        this.tDentalcauses1 = tDentalcauses1;
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
        if (!(object instanceof TDentalcauses)) {
            return false;
        }
        TDentalcauses other = (TDentalcauses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TDentalcauses[ id=" + id + " ]";
    }
    
}
