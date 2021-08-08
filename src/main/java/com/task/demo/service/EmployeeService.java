package com.task.demo.service;

import java.util.ArrayList;
//import java.util.Li;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.task.demo.dto.Employee;

@Service
public class EmployeeService {

	private Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	public static HashMap<Integer, Employee> EMPLOYEE_MAP = new HashMap<Integer, Employee>();

	public List<Employee> getAllEmployee() {
		List<Employee> empList = new ArrayList<Employee>();  
		Employee e = null;

		for (Integer key: EMPLOYEE_MAP.keySet()) {
			e = EMPLOYEE_MAP.get(key);
			empList.add(e);
		}
		logger.info("Employee List: "+empList.toString());

		return empList;

	}

	public List<Employee> getAllEmployee(String searchText) {
		logger.info("SearchText: "+searchText);
		List<Employee> empList = new ArrayList<Employee>();  
		Employee e = null;

		for (Integer key: EMPLOYEE_MAP.keySet()) {
			e = EMPLOYEE_MAP.get(key);
			if(!searchText.equals("All") && e.toString().contains(searchText)) {
				empList.add(e);
			}
			else if(searchText.equals("All")) {
				empList.add(e);
			}
		}
		logger.info("Employee List: "+empList.toString());

		return empList;

	}

	public String updateEmployee(int id, Employee e) {
		if(EMPLOYEE_MAP.containsKey(id)) {
			EMPLOYEE_MAP.put(id, e);
			return "Updated";
		}
		else {
			return "Record Not Found!!!";
		}
	}

	public Employee saveEmployee(Employee e) {
		EMPLOYEE_MAP.put(e.getId(), e);
		return e;
	}

}
