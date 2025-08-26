package com.sai.spring.springjdbc.business;

import java.sql.SQLException;

import com.sai.spring.springjdbc.model.Employee;

public interface EmployeeBusiness {

	public int insertEmployee(Employee employee) throws ClassNotFoundException, SQLException;
	
	public void printEmployeeHike() throws ClassNotFoundException, SQLException ;

	public Employee getEmployeeById(String id);
	
	public int updateEmployeeById(String empId);
	
	public int deleteEmployeeById(String empId);
	
}
