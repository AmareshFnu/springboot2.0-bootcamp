package com.testing.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testing.springboot.dao.Employee;
import com.testing.springboot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/getEmployee")
	public List<Employee> getEmployee() {
		return employeeService.getEmployee();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/createEmployee")
	private String createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return "employee creted successfully";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteEmployee/{empId}")
	private String createEmployee(@PathVariable String empId) {
		employeeService.deleteEmployee(empId);
		return "EmpID::" 	+ empId +  "has been deleted successfuly";
	}
}
