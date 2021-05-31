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
@Table(name = "m_age_immunization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MAgeImmunization.findAll", query = "SELECT m FROM MAgeImmunization m")
    , @NamedQuery(name = "MAgeImmunization.findById", query = "SELECT m FROM MAgeImmunization m WHERE m.id = :id")
    , @NamedQuery(name = "MAgeImmunization.findByAge", query = "SELECT m FROM MAgeImmunization m WHERE m.age = :age")
    , @NamedQuery(name = "MAgeImmunization.findByWeeks", query = "SELECT m FROM MAgeImmunization m WHERE m.weeks = :weeks")
    , @NamedQuery(name = "MAgeImmunization.findByCreatedon", query = "SELECT m FROM MAgeImmunization m WHERE m.createdon = :createdon")})
public class MAgeImmunization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Age")
    private String age;
    @Column(name = "Weeks")
    private Integer weeks;
    @Column(name = "Createdon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @JoinColumn(name = "CreatedUserId", referencedColumnName = "Id")
    @ManyToOne
    private MUser createdUserId;

    public MAgeImmunization() {
    }

    public MAgeImmunization(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
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
        if (!(object instanceof MAgeImmunization)) {
            return false;
        }
        MAgeImmunization other = (MAgeImmunization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.MAgeImmunization[ id=" + id + " ]";
    }
    
}
