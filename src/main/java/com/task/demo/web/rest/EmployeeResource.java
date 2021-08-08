package com.task.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.demo.dto.Employee;
import com.task.demo.service.EmployeeService;

@SuppressWarnings({ "unchecked", "rawtypes" })
@CrossOrigin
@RestController
@RequestMapping("/")
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;

	// for getting all employee
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> employee() {
		List<Employee> allEmployee = employeeService.getAllEmployee();
		return ResponseEntity.ok().body(allEmployee);
	}

	// for Searching
	@GetMapping("/employees/search/{searchText}")
	public ResponseEntity<List<Employee>> searchEmployee(@PathVariable String searchText) {
		List<Employee> allEmployee = employeeService.getAllEmployee(searchText);
		return ResponseEntity.ok().body(allEmployee);
	}

	//	for Update
	@PutMapping("/employee/update/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee empDetail) {
		String updateResp = employeeService.updateEmployee(id, empDetail);
		updateResp = "{\"response\":\""+updateResp+"\"}";
		return updateResp.toString();
	}
	
	// for inserting new record <not mentioned in assignment>
	@PutMapping("/employee")
	public ResponseEntity<List<Employee>> putEmployee(@RequestBody Employee empDetail) {
		try {
			return new ResponseEntity(employeeService.saveEmployee(empDetail),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Something went wrong ",HttpStatus.BAD_REQUEST);
		}
	}
}