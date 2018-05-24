package com.testing.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testing.springboot.dao.Employee;
import com.testing.springboot.entity.Repository;

@Service
public class EmployeeService {

	@Autowired
	private Repository rep;

	private List<Employee> employeeList = new ArrayList<>();

	public EmployeeService() {
		employeeList.add(new Employee("4568", "Amaresh", "10000", "Sr QA Analayst"));

	}

	public List<Employee> getEmployee() {
		List<Employee> employeeList = new ArrayList<>();
		rep.findAll().forEach(employeeList::add);
		;
		return employeeList;
	}

	public void createEmployee(Employee employee) {
		rep.save(employee);
		// employeeList.add(employee);
	}

	public void deleteEmployee(Employee employee) {
		rep.delete(employee);
	}

}
