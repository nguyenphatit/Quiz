package com.spring.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
@Entity
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_acc")
    private Integer idAcc;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;
    @Size(max = 50)
    @Column(name = "job")
    private String job;
    @Column(name = "gender")
    private Boolean gender;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Column(name = "state")
    private Boolean state;
    @JoinTable(name = "room_manage", joinColumns = {
        @JoinColumn(name = "id_acc", referencedColumnName = "id_acc")}, inverseJoinColumns = {
        @JoinColumn(name = "id_room", referencedColumnName = "id_room")})
    @ManyToMany
    private List<Room> roomList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Task> taskList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcc")
    private List<Post> postList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcc")
    private List<Comment> commentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcc")
    private List<Room> roomList1;

    public Account() {
    }

    public Account(Integer idAcc) {
        this.idAcc = idAcc;
    }

    public Account(Integer idAcc, String email, String password) {
        this.idAcc = idAcc;
        this.email = email;
        this.password = password;
    }

    public Integer getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(Integer idAcc) {
        this.idAcc = idAcc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @XmlTransient
    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @XmlTransient
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @XmlTransient
    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @XmlTransient
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @XmlTransient
    public List<Room> getRoomList1() {
        return roomList1;
    }

    public void setRoomList1(List<Room> roomList1) {
        this.roomList1 = roomList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcc != null ? idAcc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.idAcc == null && other.idAcc != null) || (this.idAcc != null && !this.idAcc.equals(other.idAcc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.domain.Account[ idAcc=" + idAcc + " ]";
    }
    
}
