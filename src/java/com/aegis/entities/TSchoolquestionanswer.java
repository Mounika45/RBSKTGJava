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
@Table(name = "t_schoolquestionanswer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSchoolquestionanswer.findAll", query = "SELECT t FROM TSchoolquestionanswer t")
    , @NamedQuery(name = "TSchoolquestionanswer.findById", query = "SELECT t FROM TSchoolquestionanswer t WHERE t.id = :id")
    , @NamedQuery(name = "TSchoolquestionanswer.findByAnswer", query = "SELECT t FROM TSchoolquestionanswer t WHERE t.answer = :answer")
    , @NamedQuery(name = "TSchoolquestionanswer.findByCreatedDate", query = "SELECT t FROM TSchoolquestionanswer t WHERE t.createdDate = :createdDate")})
public class TSchoolquestionanswer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Answer")
    private boolean answer;
    @Basic(optional = false)
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "SchoolId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MSchool schoolId;
    @JoinColumn(name = "QuestionId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MSchoolquestion questionId;
    @JoinColumn(name = "CreatedTeamId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MTeam createdTeamId;

    public TSchoolquestionanswer() {
    }

    public TSchoolquestionanswer(Integer id) {
        this.id = id;
    }

    public TSchoolquestionanswer(Integer id, boolean answer, Date createdDate) {
        this.id = id;
        this.answer = answer;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public MSchool getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(MSchool schoolId) {
        this.schoolId = schoolId;
    }

    public MSchoolquestion getQuestionId() {
        return questionId;
    }

    public void setQuestionId(MSchoolquestion questionId) {
        this.questionId = questionId;
    }

    public MTeam getCreatedTeamId() {
        return createdTeamId;
    }

    public void setCreatedTeamId(MTeam createdTeamId) {
        this.createdTeamId = createdTeamId;
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
        if (!(object instanceof TSchoolquestionanswer)) {
            return false;
        }
        TSchoolquestionanswer other = (TSchoolquestionanswer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.entities.TSchoolquestionanswer[ id=" + id + " ]";
    }
    
}
