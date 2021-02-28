package com.vti.entity.primarykey;

import javax.persistence.Column;
import java.io.Serializable;

public class GroupAccountKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
	private short groupId;

	@Column(name = "AccountID")
	private short accountId;

	public GroupAccountKey() {
	}

	public short getGroupId() {
		return groupId;
	}

	public void setGroupId(short groupId) {
		this.groupId = groupId;
	}

	public short getAccountId() {
		return accountId;
	}

	public void setAccountId(short accountId) {
		this.accountId = accountId;
	}
}
