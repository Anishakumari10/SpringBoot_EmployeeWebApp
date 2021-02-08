package com.employee.com.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="ename")
	private String ename;
	@Column(name="dept")
	private String dept;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Employee(long id, String ename, String dept) {
		super();
		this.id = id;
		this.ename = ename;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", dept=" + dept + "]";
	}
	public Employee() {}

}