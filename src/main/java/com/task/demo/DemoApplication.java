package com.task.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.task.demo.dto.Employee;
import com.task.demo.service.EmployeeService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	protected final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee e = new Employee(1,"Abdul","abdul@gmail.com","Mumbai");
		employeeService.saveEmployee(e);
		e = new Employee(2,"AAA","aaa@gmail.com","aaaa");
		employeeService.saveEmployee(e);
		e = new Employee(3,"BBB","bbb@gmail.com","bbbb");
		employeeService.saveEmployee(e);
		e = new Employee(4,"CCC","ccc@gmail.com","cccc");
		employeeService.saveEmployee(e);
		e = new Employee(5,"DDD","ddd@gmail.com","dddd");
		employeeService.saveEmployee(e);
		logger.info("**********************Application Started Successfully**************************");
		logger.info("Predefined Data: "+employeeService.getAllEmployee());
		
	}

}
