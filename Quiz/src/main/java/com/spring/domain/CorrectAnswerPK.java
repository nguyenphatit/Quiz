package com.spring.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class CorrectAnswerPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "id_question")
    private int idQuestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_answer")
    private int idAnswer;

    public CorrectAnswerPK() {
    }

    public CorrectAnswerPK(int idQuestion, int idAnswer) {
        this.idQuestion = idQuestion;
        this.idAnswer = idAnswer;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idQuestion;
        hash += (int) idAnswer;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CorrectAnswerPK)) {
            return false;
        }
        CorrectAnswerPK other = (CorrectAnswerPK) object;
        if (this.idQuestion != other.idQuestion) {
            return false;
        }
        if (this.idAnswer != other.idAnswer) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.domain.CorrectAnswerPK[ idQuestion=" + idQuestion + ", idAnswer=" + idAnswer + " ]";
    }
    
}
