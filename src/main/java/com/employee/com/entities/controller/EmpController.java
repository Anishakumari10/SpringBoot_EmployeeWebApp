package com.employee.com.entities.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.com.entities.Employee;
import com.employee.com.entities.service.EmployeeService;

//@RestController
@Controller
public class EmpController {

	@Autowired
	EmployeeService service;

	@RequestMapping("/empsave")
	public ModelAndView CreateEmployee(@ModelAttribute("employee") Employee e) {
		ModelAndView mav = new ModelAndView("employeesList");
		service.CreateEmployee(e);
		mav.addObject("list", service.findAll());
//		return new ResponseEntity<String>("Employee has been created", HttpStatus.CREATED);
		return mav;
	}

	@GetMapping("/empgetall")
	public List<Employee> Findall() {
		return service.findAll();
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView get() {
		ModelAndView mav = new ModelAndView("employeesList");
		mav.addObject("list", service.findAll());
		return mav; 
	} 
	@RequestMapping("/showEmployeeForm")
	public ModelAndView showEmployeeForm() {
		ModelAndView mav = new ModelAndView("employeesAdd");
		mav.addObject("employee", new Employee());
		return mav;
	}

	@RequestMapping("/empget")
	public ModelAndView FindById(@RequestParam("id") long id) {
		ModelAndView mav = new ModelAndView("employeesAdd");
		Optional<Employee> e = service.FindById(id);
		mav.addObject("employee", e);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView DeleteById(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("employeesList");
		service.DeleteById(id);
		mav.addObject("list", service.findAll());
		return mav;
	}

	@PutMapping("/empupdate/{id}")
	public String UpdateById(@RequestBody Employee e, @PathVariable("id") long id) {
		service.UpdateById(e, id);
		return "Record updated Successfully";

	}

	@PutMapping("/empgetupdate/{dept}/{dept1}")
	public String Updatedept(@PathVariable String dept, @PathVariable String dept1) {
		service.updateEmployee(dept, dept1);
		return "Employee has been updated";
	}

	@DeleteMapping("/empdelid/{id}")
	public String DelUser(@PathVariable long id) {
		service.deleteEmp(id);
		return "Employee with Id: " + id + " is deleted";
	}

	@GetMapping("/empgetdept/{dept}")
	public List<Employee> FindDept(@PathVariable String dept) {
		return service.FindByDeptSorted(dept);
	}

	@RequestMapping("/file:/C:/Users/Anil Kumar/Employee/src/main/resources/templates/index.html")
	public String viewHome() {
		return "index";
	}
//		@RequestMapping("/file:/C:/Users/Anil Kumar/Employee/src/main/resources/templates/login.html")
//	    public String viewLogin() {
//	        return "login";
//	}
}
