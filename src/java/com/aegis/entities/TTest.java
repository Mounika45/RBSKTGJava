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
@Table(name = "t_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTest.findAll", query = "SELECT t FROM TTest t")
    , @NamedQuery(name = "TTest.findById", query = "SELECT t FROM TTest t WHERE t.id = :id")
    , @NamedQuery(name = "TTest.findByTestId", query = "SELECT t FROM TTest t WHERE t.testId = :testId")
    , @NamedQuery(name = "TTest.findByDiagnosisId", query = "SELECT t FROM TTest t WHERE t.diagnosisId = :diagnosisId")
    , @NamedQuery(name = "TTest.findByResult", query = "SELECT t FROM TTest t WHERE t.result = :result")
    , @NamedQuery(name = "TTest.findByRemarks", query = "SELECT t FROM TTest t WHERE t.remarks = :remarks")
    , @NamedQuery(name = "TTest.findByIsDeleted", query = "SELECT t FROM TTest t WHERE t.isDeleted = :isDeleted")
    , @NamedQuery(name = "TTest.findByResultDate", query = "SELECT t FROM TTest t WHERE t.resultDate = :resultDate")
    , @NamedQuery(name = "TTest.findByCreatedUserId", query = "SELECT t FROM TTest t WHERE t.createdUserId = :createdUserId")
    , @NamedQuery(name = "TTest.findByCreatedOn", query = "SELECT t FROM TTest t WHERE t.createdOn = :createdOn")})
public class TTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "TestId")
    private Integer testId;
    @Column(name = "DiagnosisId")
    private Integer diagnosisId;
    @Column(name = "Result")
    private String result;
    @Column(name = "Remarks")
    private String remarks;
    @Column(name = "IsDeleted")
    private Boolean isDeleted;
    @Column(name = "ResultDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resultDate;
    @Column(name = "CreatedUserId")
    private Integer createdUserId;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public TTest() {
    }

    public TTest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Integer diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
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
        if (!(object instanceof TTest)) {
            return false;
        }
        TTest other = (TTest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TTest[ id=" + id + " ]";
    }
    
}
