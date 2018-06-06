package com.testing.springboot.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.offbytwo.jenkins.JenkinsServer;
//import com.offbytwo.jenkins.JenkinsServer;
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
		return "EmpID::" + empId + "has been deleted successfuly";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/build/{jobname}")
	// private String triggerJenkinsBuild(@PathVariable String jobname, String
	// username, String password)
	private String triggerJenkinsBuild(@PathVariable String jobname) throws URISyntaxException, IOException {

		JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080"), "admin",
				"ac1f8dd677de41f7942633e3118778af");

		boolean crumbFlag = true;

		Map<String, com.offbytwo.jenkins.model.Job> jobs = jenkins.getJobs();

		jobs.get(jobname).build(crumbFlag);

		System.out.println(jobs);
		return "Build has been triggered successfuly";
	}

}
