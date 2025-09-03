package com.sai.spring.springjdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sai.spring.springjdbc.model.Employee;

@Component("employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> findAllEmployees() throws ClassNotFoundException, SQLException {

		// JDBC code

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/springjdbc";
		String username = "root";
		String password = "root";

		List<Employee> employees = new ArrayList<Employee>();

		Class.forName(driver);

		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);			
		} 
		
		catch (SQLException e)
		
		{
			e.printStackTrace();
		}
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");
		
		while (rs.next()) {

			String id = rs.getString(1);
			String name = rs.getString(2);
			int experiance = rs.getInt(3);

			employees.add(new Employee(id, name, experiance));

		}

		con.close();
		return employees;
	}

	@Override
	public int insertEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		return 0;

	}

	@Override
	public Employee getEmployeeById(String id) {
		return null;
	}

	@Override
	public int updateEmployeeById(String empId) {
		return 0;

	}

	@Override
	public int deleteEmployeeById(String empId) {
		return 0;

	}

}
