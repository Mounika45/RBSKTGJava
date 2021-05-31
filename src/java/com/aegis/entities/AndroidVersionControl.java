/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "AndroidVersionControl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AndroidVersionControl.findAll", query = "SELECT a FROM AndroidVersionControl a")
    , @NamedQuery(name = "AndroidVersionControl.findById", query = "SELECT a FROM AndroidVersionControl a WHERE a.id = :id")
    , @NamedQuery(name = "AndroidVersionControl.findByVersionName", query = "SELECT a FROM AndroidVersionControl a WHERE a.versionName = :versionName")
    , @NamedQuery(name = "AndroidVersionControl.findByVersionCode", query = "SELECT a FROM AndroidVersionControl a WHERE a.versionCode = :versionCode")
    , @NamedQuery(name = "AndroidVersionControl.findByLink", query = "SELECT a FROM AndroidVersionControl a WHERE a.link = :link")})
public class AndroidVersionControl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "VersionName")
    private String versionName;
    @Column(name = "VersionCode")
    private String versionCode;
    @Column(name = "Link")
    private String link;

    public AndroidVersionControl() {
    }

    public AndroidVersionControl(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        if (!(object instanceof AndroidVersionControl)) {
            return false;
        }
        AndroidVersionControl other = (AndroidVersionControl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.AndroidVersionControl[ id=" + id + " ]";
    }
    
}
