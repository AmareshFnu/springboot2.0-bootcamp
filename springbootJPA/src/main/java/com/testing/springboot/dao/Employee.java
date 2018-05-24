package com.testing.springboot.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	public Employee(String empID, String empName, String empSalary, String empDesignation) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empDesignation = empDesignation;
	}

	public Employee() {

	}

	private String empID;

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	@Id
	private String empName;
	private String empSalary;
	private String empDesignation;

}
