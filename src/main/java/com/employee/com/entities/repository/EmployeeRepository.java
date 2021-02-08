package com.employee.com.entities.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.com.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	//named query
	@Query("from Employee where dept=:dname order by ename")
	List<Employee> FindByDeptSorted(@Param("dname") String dept);

	// index query
	@Transactional
	@Modifying
	@Query("update Employee e set e.dept=?2 where e.dept=?1")
	void updateEmployee(String dept, String dept1);

	@Transactional
	@Modifying
	@Query("delete from Employee e where e.id=:id")
	void deleteEmp(@Param("id") long id);
}
