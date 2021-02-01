package com.vti;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

import java.sql.Date;
import java.util.List;

public class program {
    public static void main(String[] args) {
        GroupRepository repository=new GroupRepository();

        System.out.println("***********GET ALL Groups***********");

        List<Group> groups = repository.getAllGroups();

        for (Group group : groups) {
            System.out.println(group);
        }

		System.out.println("\n\n***********GET Group BY ID***********");

		Group groupById = repository.getGroupByID((int) 2);
		System.out.println(groupById);

		System.out.println("\n\n***********GET Group BY NAME***********");

		Group groupByName = repository.getGroupByName("PM4");
		System.out.println(groupByName);

        System.out.println("\n\n***********CREATE Group***********");

        Group groupCreate = new Group();
        groupCreate.setGroupName("PM4");
        repository.createGroup(groupCreate);

		System.out.println("\n\n***********UPDATE Group 1***********");

		repository.updateGroup((int) 3, "Security");

		System.out.println("\n\n***********UPDATE Group 11***********");

		Group groupUpdate = new Group();
		groupUpdate.setGroupID((int) 11);
		groupUpdate.setGroupName("Security3");
        groupUpdate.setCreateDate(Date.valueOf("2020-09-09"));
		repository.updateGroup(groupUpdate);

		System.out.println("\n\n***********DELETE Group***********");
		repository.deleteGroup((int) 10);

		System.out.println("***********CHECK Group EXISTS BY ID***********");
		System.out.println(repository.isGroupExistsByID((int) 1));

		System.out.println("***********CHECK Group EXISTS BY NAME***********");
		System.out.println(repository.isGroupExistsByName("Security"));

    }
}
