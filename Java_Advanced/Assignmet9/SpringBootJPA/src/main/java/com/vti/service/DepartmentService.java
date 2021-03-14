package com.vti.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.entity.Filter;
import com.vti.repository.IDepartmentRepository;


@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	public List<Department> getAllDepartments(Filter filter, String search) {
		Specification<Department> where=null;
		if(filter.getMinMember()>=0) {//kiem tra ton tai
			where=greaterThanMinMember(filter.getMinMember());
		}
		if(filter.getMaxMember()!=0) {
			if(filter.getMinMember()>=0) {
				where = where.and(lessThanMaxMember(filter.getMaxMember()));
			}
			else {
				where=lessThanMaxMember(filter.getMaxMember());
			}			
		}
		if(search !=null && search !="") {
			if(where !=null) {
				where=where.and(searchByField(search, "name"));//neu có thêm truong string nữa thì... 
				//where=(searchByField(search, "firstname").or(searchByField(search, "lastname"));
			}
			else {
				where=searchByField(search, "name");
			}
		}
		Pageable pageable=null;
		if(filter.getField()!=null && filter.getField().equals("")!=true){
			pageable=PageRequest.of(filter.getPage(), filter.getPageSize(), filter.getType().equals("asc") ? Sort.by(filter.getField()).ascending(): Sort.by(filter.getField()).descending());
		}
		else {
			pageable=PageRequest.of(filter.getPage(), filter.getPageSize());
		}
		
		return (List<Department>) repository.findAll(where,pageable).toList();
	}
	//tìm kiếm department có totalmember > minMember
	public Specification<Department>greaterThanMinMember(int minMember){
		return new Specification<Department>() {
			@Override
			public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.greaterThan(root.get("totalMember"), minMember);
			}
			
		};	
	}
	public Specification<Department>lessThanMaxMember(int maxMember){
		return new Specification<Department>() {
			@Override
			public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.lessThan(root.get("totalMember"), maxMember);
			}
			
		};	
	}
	public Specification<Department>searchByField(String seacrh, String type){
		return new Specification<Department>() {

			@Override
			
			public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
			
				return criteriaBuilder.like(root.get(type), "%"+seacrh+"%");
			}
			
		};
		
	}
		
	public Department getDepartmentByID(short id) {
		return repository.findById(id);
	}

	public Department getDepartmentByName(String name) {
		return repository.findByName(name);
	}
	public boolean isDepartmentExistsByID(short id) {
		return repository.existsById(id);
	}

	public boolean isDepartmentExistsByName(String name) {
		return repository.existsByName(name);
	}
	public void createDepartment(Department department) {
		repository.save(department);
	}

	public void updateDepartment(Department department) {
		repository.save(department);
	}

	public void deleteDepartment(short id) {
		repository.deleteById(id);
	}

	
}
