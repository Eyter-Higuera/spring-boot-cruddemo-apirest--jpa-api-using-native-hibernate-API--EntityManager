package com.eyterhiguera.springboot.cruddemo.apirest.dao;

import java.util.List;

import com.eyterhiguera.springboot.cruddemo.apirest.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
