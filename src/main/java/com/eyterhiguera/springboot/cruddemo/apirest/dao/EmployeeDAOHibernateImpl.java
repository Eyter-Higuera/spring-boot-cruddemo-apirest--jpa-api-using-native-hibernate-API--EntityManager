package com.eyterhiguera.springboot.cruddemo.apirest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eyterhiguera.springboot.cruddemo.apirest.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	//define field for entitymanager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		
		 this.entityManager = theEntityManager;
	}

	@Override
//we remove @Transactional from DAO, we will add a Service to handle @Transactional
	public List<Employee> findAll() {
	
		//get the current hibernate session
		//Session.class = get current hibernate session
		//choose: import org.hibernate.Session;
		//We are using native Hibernate API in this work
//If you want to use the native Hibernate API, 
//then you can make use of the Hibernate SessionFactory (via unwrapping it).
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		//choose: 'import Query'(org.hibernate.query)
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		//return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
	
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save employee
		//if id=0 then save/insert  else update
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
	
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with primary key
	    Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		
	     theQuery.setParameter("employeeId", theId);
	     
	     theQuery.executeUpdate();  
	}

}
