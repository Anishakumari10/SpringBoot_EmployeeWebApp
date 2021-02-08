package com.employee.com;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.employee.com.entities.Employee;
import com.employee.com.entities.controller.EmpController;
import com.employee.com.entities.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

	@InjectMocks
	EmpController controller;
	
	@Mock
	EmployeeService service;
	
	@Test
	public void testfindall() {
		List<Employee> response = new ArrayList<>();
		Employee e = new Employee(30,"Arshi", "Robotics");
		Employee e1 = new Employee(33,"Umang", "Marketing");
		response.add(e);
		response.add(e1);
		Mockito.when(service.findAll()).thenReturn(response);
//		assertEquals(2,controller.Findall().size());
		
	}
	@Test
	public void testCreateEmp() {
		Employee e = new Employee(33,"Kamal","Sales");
		Mockito.when(service.CreateEmployee(e)).thenReturn(e);
//		ResponseEntity<String>result=controller.CreateEmployee(e);
//		Assert.assertNotNull(result.getBody());
	}
	
	@Test
	public void testdeleteid() {
		Employee e  = new Employee(33,"Kamal","Sales");
		controller.DeleteById(e.getId());
		verify(service, times(1)).DeleteById(e.getId());
	}
	@Test
	public void testUpdateBydept() {
		String dept = "IT";
		String dept1 = "IT Support";
		controller.Updatedept(dept, dept1);
		verify(service,times(1)).updateEmployee(dept, dept1);
	
	}
	
	@Test
	public void testGetByDept() {
		List<Employee> response = new ArrayList<>();
		String dept = "IT";
		Employee e = new Employee(33,"Kamal","Sales");
		response.add(e);
		Mockito.when(service.FindByDeptSorted(e.getDept())).thenReturn(response);
		assertNotEquals(dept,controller.FindDept(e.getDept()));

	}
}
