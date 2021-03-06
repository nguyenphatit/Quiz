package com.spring.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name = "correct_answer")
public class CorrectAnswer implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected CorrectAnswerPK correctAnswerPK;
	@Lob
	@Size(max = 2147483647)
	@Column(name = "answer_content")
	private String answerContent;
	@Column(name = "correct_answer")
	private Boolean correctAnswer;
	@JoinColumn(name = "id_question", referencedColumnName = "id_question", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Question question;

	public CorrectAnswer() {
	}

	public CorrectAnswer(CorrectAnswerPK correctAnswerPK) {
		this.correctAnswerPK = correctAnswerPK;
	}

	public CorrectAnswer(int idQuestion, int idAnswer) {
		this.correctAnswerPK = new CorrectAnswerPK(idQuestion, idAnswer);
	}

	public CorrectAnswerPK getCorrectAnswerPK() {
		return correctAnswerPK;
	}

	public void setCorrectAnswerPK(CorrectAnswerPK correctAnswerPK) {
		this.correctAnswerPK = correctAnswerPK;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Boolean getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (correctAnswerPK != null ? correctAnswerPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof CorrectAnswer)) {
			return false;
		}
		CorrectAnswer other = (CorrectAnswer) object;
		if ((this.correctAnswerPK == null && other.correctAnswerPK != null)
				|| (this.correctAnswerPK != null && !this.correctAnswerPK.equals(other.correctAnswerPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.spring.domain.CorrectAnswer[ correctAnswerPK=" + correctAnswerPK + " ]";
	}

}
