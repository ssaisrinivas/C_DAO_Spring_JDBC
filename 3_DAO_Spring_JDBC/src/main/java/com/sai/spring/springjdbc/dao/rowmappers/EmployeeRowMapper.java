package com.sai.spring.springjdbc.dao.rowmappers;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sai.spring.springjdbc.model.Employee;


public class EmployeeRowMapper implements RowMapper <Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		employee.setId(rs.getString(1));
		employee.setName(rs.getString(2));
		employee.setExperiance(rs.getInt(3));
		
		return employee;
	}
	
	

}
