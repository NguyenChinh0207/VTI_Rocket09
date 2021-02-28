package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "`Group`", catalog = "TestingSystem")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "`name`", length = 50, nullable = false, unique = true)
    private String name;

//    @Column(name = "author_ID",  nullable = false)
//    private short authorID;

    @ManyToOne
    @JoinColumn(name="author_ID", referencedColumnName = "id")
    private User user;

    @Column(name = "create_time" )
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;

    public Group() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public short getAuthorID() {
//        return authorID;
//    }
//
//    public void setAuthorID(short authorID) {
//        this.authorID = authorID;
//    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", createTime=" + createTime +
                '}';
    }
}
