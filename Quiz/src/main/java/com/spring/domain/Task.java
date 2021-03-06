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
@Table(name = "task")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected TaskPK taskPK;
	@Column(name = "id_answer")
	private Integer idAnswer;
	@Lob
	@Size(max = 2147483647)
	@Column(name = "note")
	private String note;
	@JoinColumn(name = "id_acc", referencedColumnName = "id_acc", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Account account;
	@JoinColumn(name = "id_question", referencedColumnName = "id_question", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Question question;
	@JoinColumn(name = "id_test", referencedColumnName = "id_test", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Test test;

	public Task() {
	}

	public Task(TaskPK taskPK) {
		this.taskPK = taskPK;
	}

	public Task(int idTest, int idAcc, int idQuestion) {
		this.taskPK = new TaskPK(idTest, idAcc, idQuestion);
	}

	public TaskPK getTaskPK() {
		return taskPK;
	}

	public void setTaskPK(TaskPK taskPK) {
		this.taskPK = taskPK;
	}

	public Integer getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(Integer idAnswer) {
		this.idAnswer = idAnswer;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (taskPK != null ? taskPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Task)) {
			return false;
		}
		Task other = (Task) object;
		if ((this.taskPK == null && other.taskPK != null)
				|| (this.taskPK != null && !this.taskPK.equals(other.taskPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.spring.domain.Task[ taskPK=" + taskPK + " ]";
	}

}
