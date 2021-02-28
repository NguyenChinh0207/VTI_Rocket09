package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "`User`", catalog = "TestingSystem")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "`username`", length = 50, nullable = false, unique = true)
    private String username;
    @Column(name = "`email`", length = 50, nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy="user")
    private List<Group> groupsCreated;

    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Group> getGroupsCreated() {
        return groupsCreated;
    }

    public void setGroupsCreated(List<Group> groupsCreated) {
        this.groupsCreated = groupsCreated;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
//                ", groupsCreated=" + groupsCreated +
                '}';
    }
}
