package de.hrdirect.backend.service;

import java.util.List;
import de.hrdirect.backend.entity.Employee;

public interface EmployeeService
{
	List< Employee > findAll ();
	
	Employee findById ( int id );
	
	Employee createEmployee ( Employee employee );
	
	void deleteEmployeeById ( int id );
	
	Employee update ( Employee employee );
}
