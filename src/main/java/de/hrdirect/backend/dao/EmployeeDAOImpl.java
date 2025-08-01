package de.hrdirect.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.hrdirect.backend.entity.Employee;
import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{

	private EntityManager entityManager;
	
	public EmployeeDAOImpl ( EntityManager _entityManager, ObjectMapper _objectMapper )
	{
		entityManager = _entityManager;
	}
	
	@Override
	public List< Employee > findAll ()
	{
		List< Employee > employees = entityManager.createQuery ( "from Employee" ).getResultList ();
		
		return employees;
	}

	@Override
	public Employee findById ( int id )
	{
		return entityManager.createQuery ( "SELECT e FROM Employee e WHERE e.id = :id", 
				Employee.class )
				.setParameter ( "id", id )
				.getSingleResult ();
	}

	@Override
	public Employee createEmployee ( Employee employee )
	{
		entityManager.persist ( employee );
		
		return employee;
	}

	@Override
	public void deleteEmployeeById ( int id )
	{
		Employee employeeToRemove = findById ( id );
		
		entityManager.remove ( employeeToRemove );
	}

	@Override
	public Employee update ( Employee employee )
	{
		entityManager.merge ( employee );
		
		return employee;
	}
}
