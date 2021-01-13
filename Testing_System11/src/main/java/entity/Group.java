/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;


public class Group {
    private int         groupId;
    private String      groupName;
    private Account     creatorID;
    private Date        createDate;


    public Group() {
    }

    public Group(int groupId, String groupName, Account creatorID, Date createDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Account creatorID) {
        this.creatorID = creatorID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", creatorID=" + creatorID +
                ", createDate=" + createDate +
                '}';
    }
}
