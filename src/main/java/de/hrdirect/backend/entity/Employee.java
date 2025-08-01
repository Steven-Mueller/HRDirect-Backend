package de.hrdirect.backend.entity;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table ( name = "employees" )
public class Employee
{
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "id" )
	private int id;

	@Column ( name = "first_name" )
	private String firstName;

	@Column ( name = "last_name" )
	private String lastName;

	@Column ( name = "email" )
	private String email;

	@Column ( name = "hiring_date" )
	private String hiringDate;

	@Column ( name = "department" )
	private String department;

	@Column ( name = "date_of_birth" )
	private String dateOfBirth;

	public Employee ()
	{
	}

	@Autowired
	public Employee ( int id, String firstName, String lastName, String email, String hiringDate, String department,
			String dateOfBirth )
	{
		super ();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hiringDate = hiringDate;
		this.department = department;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId ()
	{
		return id;
	}

	public void setId ( int id )
	{
		this.id = id;
	}

	public String getFirstName ()
	{
		return firstName;
	}

	public void setFirstName ( String firstName )
	{
		this.firstName = firstName;
	}

	public String getLastName ()
	{
		return lastName;
	}

	public void setLastName ( String lastName )
	{
		this.lastName = lastName;
	}

	public String getEmail ()
	{
		return email;
	}

	public void setEmail ( String email )
	{
		this.email = email;
	}

	public String getHiringDate ()
	{
		return hiringDate;
	}

	public void setHiringDate ( String hiringDate )
	{
		this.hiringDate = hiringDate;
	}

	public String getDepartment ()
	{
		return department;
	}

	public void setDepratment ( String department )
	{
		this.department = department;
	}

	public String getDateOfBirth ()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth ( String dateOfBirth )
	{
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString ()
	{
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", hiringDate=" + hiringDate + ", department=" + department + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
