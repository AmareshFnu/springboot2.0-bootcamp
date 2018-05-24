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
	private void createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteEmployee")
	private void deleteEmployee(@RequestBody Employee employee) {
		employeeService.deleteEmployee(employee);

	}
}
