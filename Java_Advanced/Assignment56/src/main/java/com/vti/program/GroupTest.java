package com.vti.program;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GroupTest {
	public static void main(String[] args) throws InterruptedException {
		GroupRepository repository = new GroupRepository();

		System.out.println("***********GET ALL***********");

		List<Group> groups = repository.getAllGroups();

		for (Group group : groups) {
			System.out.println(group);
//			TimeUnit.SECONDS.sleep(4);
		}
	}
}
