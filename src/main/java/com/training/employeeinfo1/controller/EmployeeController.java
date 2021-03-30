package com.training.employeeinfo1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.employeeinfo1.model.Employee;
import com.training.employeeinfo1.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id) {
		return employeeService.getEmployee(id);
	}

	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	 
	@PutMapping("/employees/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
		employeeService.updateEmployee(employee, id);
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Integer id)  {
		employeeService.deleteEmployee(id);
		
	}
	
	//@GetMapping("/error")
	//public String errorPage(){
	//return "An unexpected error has occured";
	//return "/employees" ;
	//}
}



