package de.hrdirect.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.hrdirect.backend.dao.EmployeeDAO;
import de.hrdirect.backend.entity.Employee;
import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl ( EmployeeDAO _employeeDAO )
	{
		employeeDAO = _employeeDAO;
	}
	
	@Override
	public List< Employee > findAll ()
	{
		return employeeDAO.findAll ();
	}

	@Override
	public Employee findById ( int id )
	{
		return employeeDAO.findById ( id );
	}

	@Override
	@Transactional
	public Employee createEmployee ( Employee employee )
	{
		return employeeDAO.createEmployee ( employee );
	}

	@Override
	@Transactional
	public void deleteEmployeeById ( int id )
	{
		employeeDAO.deleteEmployeeById ( id );
	}

	@Override
	@Transactional
	public Employee update ( Employee employee )
	{
		return employeeDAO.update ( employee );
	}

}
