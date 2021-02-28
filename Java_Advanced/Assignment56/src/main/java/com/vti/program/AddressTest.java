package com.vti.program;

import com.vti.entity.Address;
import com.vti.entity.Department;
import com.vti.repository.AddressRepository;

import java.util.List;

public class AddressTest {
	public static void main(String[] args) {
		AddressRepository repository = new AddressRepository();

		System.out.println("***********GET ALL***********");

		List<Address> Addresss = repository.getAllAddresses();

		for (Address address : Addresss) {
			System.out.println(address);
		}

		System.out.println("\n\n***********CREATE Address***********");

		Address addressCreate = new Address();
		addressCreate.setName("waiting");
		repository.createAddress(addressCreate);

		System.out.println("\n\n***********UPDATE Address ***********");

		repository.updateAddress((short) 3, "Security");

		System.out.println("\n\n***********UPDATE Address ***********");

		Address AddressUpdate = new Address();
		AddressUpdate.setId((short) 2);
		AddressUpdate.setName("Security2");
		repository.updateAddress(AddressUpdate);

		System.out.println("\n\n***********DELETE Address***********");
		repository.deleteAddress((short) 2);

		System.out.println("***********CHECK Address EXISTS BY ID***********");
		System.out.println(repository.isAddressExistsByID((short) 1));

		System.out.println("***********CHECK Address EXISTS BY NAME***********");
		System.out.println(repository.isAddressExistsByName("Security"));
	}
}
