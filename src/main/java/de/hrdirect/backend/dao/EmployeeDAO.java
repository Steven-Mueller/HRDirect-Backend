package de.hrdirect.backend.dao;

import java.util.List;

import de.hrdirect.backend.entity.Employee;

public interface EmployeeDAO
{
	List< Employee > findAll ();
	
	Employee findById ( int id );
	
	Employee createEmployee ( Employee employee );
	
	void deleteEmployeeById ( int id );
	
	Employee update( Employee employee );
}
