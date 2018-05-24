package com.testing.springboot.entity;

import org.springframework.data.repository.CrudRepository;

import com.testing.springboot.dao.Employee;

public interface Repository extends CrudRepository<Employee, String> {

}
