package de.hrdirect.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import de.hrdirect.backend.entity.Employee;
import de.hrdirect.backend.service.EmployeeService;

@RestController
@RequestMapping ( "/employees" )
@CrossOrigin ( origins = "http://localhost:5173" )
public class EmployeeController
{
	private EmployeeService employeeService;

	private ObjectMapper objectMapper;

	public EmployeeController ( EmployeeService _employeeService, ObjectMapper _objectMapper )
	{
		employeeService = _employeeService;

		objectMapper = _objectMapper;
	}

	@GetMapping ( "/" )
	public List< String > showOptions ()
	{
		List< String > apiOptions = new ArrayList<> ();

		apiOptions.add ( "Get all employees from database: /list" );

		apiOptions.add ( "Get employee via id from database: /employee/{id}" );

		apiOptions.add ( "Insert new employee into database: /insert" );

		apiOptions.add ( "Update employee data in database: /employee/update" );

		apiOptions.add ( "Update partial employee data in database: /employee/patch/{id}" );

		apiOptions.add ( "Delete user from database via id: /remove/{id}" );

		return apiOptions;
	}

	@GetMapping ( "/list" )
	public List< Employee > getAllEmployees ()
	{
		return employeeService.findAll ();
	}

	@GetMapping ( "/employee/{id}" )
	public Employee findEmployeeById ( @PathVariable Integer id )
	{
		return employeeService.findById ( id );
	}

	@PostMapping ( "/insert" )
	public Employee insertEmployee ( @RequestBody Employee employee )
	{
		return employeeService.createEmployee ( employee );
	}

	@PutMapping ( "/employee/update" )
	public Employee updateEmployee ( @RequestBody Employee employee )
	{
		return employeeService.update ( employee );
	}

	@PatchMapping ( "/employee/patch/{id}" )
	public Employee patchEmployee ( @PathVariable Integer id, @RequestBody Map< String, Object > payLoad )
	{
		Employee employeeInDB = employeeService.findById ( id );

		Employee patchedEmployee = apply ( payLoad, employeeInDB );

		Employee employeeToSave = employeeService.update ( patchedEmployee );

		return employeeToSave;
	}

	private Employee apply ( Map< String, Object > payLoad, Employee employeeInDB )
	{
		// Convert employee object to JSON object node
		ObjectNode employeeNode = objectMapper.convertValue ( employeeInDB, ObjectNode.class );

		// Convert the payLoad map to JSON object node
		ObjectNode payLoadNode = objectMapper.convertValue ( payLoad, ObjectNode.class );

		// Merge the payLoad data into employee data
		employeeNode.setAll ( payLoadNode );

		// Convert JSON object node back to Employee object
		return objectMapper.convertValue ( employeeNode, Employee.class );
	}

	@DeleteMapping ( "/remove/{id}" )
	public void removeEmployeeById ( @PathVariable Integer id )
	{
		employeeService.deleteEmployeeById ( id );
	}
}
