package com.testing.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testing.springboot.dao.Employee;

@Service
public class EmployeeService {

	// @Autowired
	// private Repository rep;

	private List<Employee> employeeList = new ArrayList<>();

	public EmployeeService() {
		employeeList.add(new Employee("4568", "Amaresh", "10000", "Sr QA Analayst"));

	}

	public List<Employee> getEmployee() {

		return employeeList;
	}

	public void createEmployee(Employee employee) {

		employeeList.add(employee);
	}

	public void deleteEmployee(String empID) {
		employeeList.removeIf(t -> t.getEmpID().equals(empID));
	}

}
