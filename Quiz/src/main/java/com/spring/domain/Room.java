package com.spring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
    , @NamedQuery(name = "Room.findByIdRoom", query = "SELECT r FROM Room r WHERE r.idRoom = :idRoom")
    , @NamedQuery(name = "Room.findByRoomName", query = "SELECT r FROM Room r WHERE r.roomName = :roomName")
    , @NamedQuery(name = "Room.findByRoomDescr", query = "SELECT r FROM Room r WHERE r.roomDescr = :roomDescr")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_room")
    private Integer idRoom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "room_name")
    private String roomName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "room_descr")
    private String roomDescr;
    @ManyToMany(mappedBy = "roomList")
    private List<Post> postList;
    @ManyToMany(mappedBy = "roomList")
    private List<Account> accountList;
    @JoinColumn(name = "id_acc", referencedColumnName = "id_acc")
    @ManyToOne(optional = false)
    private Account idAcc;

    public Room() {
    }

    public Room(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Room(Integer idRoom, String roomName, String roomDescr) {
        this.idRoom = idRoom;
        this.roomName = roomName;
        this.roomDescr = roomDescr;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDescr() {
        return roomDescr;
    }

    public void setRoomDescr(String roomDescr) {
        this.roomDescr = roomDescr;
    }

    @XmlTransient
    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @XmlTransient
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Account getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(Account idAcc) {
        this.idAcc = idAcc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoom != null ? idRoom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.idRoom == null && other.idRoom != null) || (this.idRoom != null && !this.idRoom.equals(other.idRoom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.domain.Room[ idRoom=" + idRoom + " ]";
    }
    
}
