package com.eyterhiguera.springboot.cruddemo.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eyterhiguera.springboot.cruddemo.apirest.dao.EmployeeDAO;
import com.eyterhiguera.springboot.cruddemo.apirest.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	//inject EmployeeDAO 
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		
		this.employeeDAO = theEmployeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
	
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
	
         employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
	
		employeeDAO.deleteById(theId);

	}

}
