package com.employee.com;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.com.entities.Employee;
import com.employee.com.entities.repository.EmployeeRepository;
import com.employee.com.entities.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeApplicationTests {
	
//	@Autowired
//	EmployeeRepository repo;
//	@Test
//	public void testCreateEmployee() {
//		Employee em= new Employee();
//			em.setEname("bbb");
//			em.setDept("IT");
//			repo.save(em);
//			
//		}
//	@Test
//	public void testFindById() {
//		Optional<Employee>em=repo.findById(1l);
//		System.out.println(em);
//	}
//
//	@Test
//	public void testUpdateEmployee() {
//		Employee em = repo.findById(2l).get();
//		em.setEname("Karan");
//		em.setDept("Cyber Security");
//		repo.save(em);
//	}
//
//	@Test
//	public void testDeleteEmployee() {
//		Employee em = new Employee();
//		em.setId(3l);
//		repo.delete(em);
//		
//	}
	
@InjectMocks
private EmployeeService service;

	@Mock
	private EmployeeRepository repo;
	
	@Test
	public void findAll() {
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Employee(22,"Mani","IT"),new Employee(25,"Kiran","Sales")).collect(Collectors.toList()));
		assertEquals(2,service.findAll().size());
	}
	@Test
	public void FindById() {
		long id = 25;
		service.FindById(id);
		verify(repo,times(1)).findById((long) id);
	}
	
	@Test
	public void FindByDeptSorted() {
		String dept = "Sales";
		Mockito.when(repo.FindByDeptSorted(dept)).thenReturn(Stream.of(new Employee(25,"Kiran","Sales")).collect(Collectors.toList()));
		assertEquals(1,service.FindByDeptSorted(dept).size());
	}

	@Test
	public void saveEmp() {
		Employee emp = new Employee(30,"Vijaya","Sales");
		Mockito.when(repo.save(emp)).thenReturn(emp);
		assertEquals(emp, service.CreateEmployee(emp));
	}
	@Test
	public void UpdateById() {
		String dept = "IT";
		String dept1 = "IT Support";
		service.updateEmployee(dept, dept1);
		verify(repo,times(1)).updateEmployee(dept, dept1);
		
	}
	@Test
	public void deleteUserTest() {
		Employee emp = new Employee(30, "Vijaya", "Sales");
		service.DeleteById(emp.getId());
		verify(repo, times(1)).deleteById((long) 30);
	}
	
	
	
	
	
	
	
	
	

}
