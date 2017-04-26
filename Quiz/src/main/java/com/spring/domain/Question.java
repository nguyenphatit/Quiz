
package com.spring.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
@Entity
@Table(name = "question")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_question")
    private Integer idQuestion;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "question_content")
    private String questionContent;
    @JoinColumn(name = "question_type", referencedColumnName = "param_name")
    @ManyToOne
    private ClList2 questionType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuestion")
    private List<CorrectAnswer> correctAnswerList;

    public Question() {
    }

    public Question(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public ClList2 getQuestionType() {
        return questionType;
    }

    public void setQuestionType(ClList2 questionType) {
        this.questionType = questionType;
    }

    @XmlTransient
    public List<CorrectAnswer> getCorrectAnswerList() {
        return correctAnswerList;
    }

    public void setCorrectAnswerList(List<CorrectAnswer> correctAnswerList) {
        this.correctAnswerList = correctAnswerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestion != null ? idQuestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.idQuestion == null && other.idQuestion != null) || (this.idQuestion != null && !this.idQuestion.equals(other.idQuestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.domain.Question[ idQuestion=" + idQuestion + " ]";
    }
    
}
