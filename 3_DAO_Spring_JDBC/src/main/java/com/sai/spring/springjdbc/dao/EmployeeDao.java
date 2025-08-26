package com.sai.spring.springjdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.sai.spring.springjdbc.model.Employee;

public interface EmployeeDao {

	public int insertEmployee(Employee employee) throws ClassNotFoundException, SQLException;
	
	public List<Employee> findAllEmployees() throws ClassNotFoundException, SQLException ;
	
	public Employee getEmployeeById(String id);
	
	public int updateEmployeeById(String empId);
	
	public int deleteEmployeeById(String empId);
}
