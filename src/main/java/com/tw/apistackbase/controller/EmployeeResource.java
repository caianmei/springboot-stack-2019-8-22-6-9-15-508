package com.tw.apistackbase.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import domain.Employee;
import domain.Employees;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

	Employees employees = new Employees();
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Employee>> queryAll(){		
		return ResponseEntity.ok(employees.getEmployees());
	}	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Employee> queryItem(@PathVariable String id){	
		System.out.println(employees.getEmployees().size());
		for (Employee employee : employees.getEmployees()) {
			if (employee.getId().equalsIgnoreCase(id)) {
				return ResponseEntity.ok(employee);
			}
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}	
	
	@PostMapping(path = "/")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee addEmployee(@RequestBody Employee employee){
		employees.setEmployees(employee);
		return employee;
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String id,@RequestBody Employee employee){
		for (Employee beforeEmployee : employees.getEmployees()) {
			if (beforeEmployee.getId().equalsIgnoreCase(id)) {
				if (employee.getName() != null) {
					beforeEmployee.setName(employee.getName());
				}
				if (employee.getAge() != null) {
					beforeEmployee.setAge(employee.getAge());
				}
				if (employee.getGender()!= null) {
					beforeEmployee.setGender(employee.getGender());
				}
				return ResponseEntity.ok(beforeEmployee);
			}
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable String id){
		for (Employee beforeEmployee : employees.getEmployees()) {
			if (beforeEmployee.getId().equalsIgnoreCase(id)) {
				employees.getEmployees().remove(beforeEmployee);
				return new ResponseEntity<Employee>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
}
