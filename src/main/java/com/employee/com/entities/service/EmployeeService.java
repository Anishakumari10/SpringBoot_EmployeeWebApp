package com.employee.com.entities.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.com.entities.Employee;
import com.employee.com.entities.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public Employee CreateEmployee(Employee e) {
		return repo.save(e);

	}

	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		repo.findAll().forEach(empList::add);
		return empList;

	}

	public Optional<Employee> FindById(long id) {
		return repo.findById(id);
	}

	public void DeleteById(long id) {
		repo.deleteById(id);

	}

	public void UpdateById(Employee e, long id) {
		repo.save(e);

	}

	public void updateEmployee(String dept, String dept1) {
		repo.updateEmployee(dept, dept1);
		
	}

	public void deleteEmp(long id) {
		repo.deleteEmp(id);
		
	}

	public List<Employee> FindByDeptSorted(String dept) {
		List<Employee> empList = new ArrayList<>();
		repo.FindByDeptSorted(dept).forEach(empList::add);
		return empList;
	}
	
	
	
	
	
	
}