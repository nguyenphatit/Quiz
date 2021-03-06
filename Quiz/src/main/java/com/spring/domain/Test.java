package com.spring.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "test")
public class Test implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_test")
	private Integer idTest;
	@Size(max = 100)
	@Column(name = "title")
	private String title;
	@Column(name = "date_start")
	@Temporal(TemporalType.DATE)
	private Date dateStart;
	@Column(name = "date_end")
	@Temporal(TemporalType.DATE)
	private Date dateEnd;
	@ManyToMany(mappedBy = "testList")
	private List<Question> questionList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
	private List<Task> taskList;

	public Test() {
	}

	public Test(Integer idTest) {
		this.idTest = idTest;
	}

	public Integer getIdTest() {
		return idTest;
	}

	public void setIdTest(Integer idTest) {
		this.idTest = idTest;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	@XmlTransient
	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	@XmlTransient
	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idTest != null ? idTest.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Test)) {
			return false;
		}
		Test other = (Test) object;
		if ((this.idTest == null && other.idTest != null)
				|| (this.idTest != null && !this.idTest.equals(other.idTest))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.spring.domain.Test[ idTest=" + idTest + " ]";
	}

}
