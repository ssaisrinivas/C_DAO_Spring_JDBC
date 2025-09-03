package com.sai.spring.springjdbc.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sai.spring.springjdbc.dao.rowmappers.EmployeeRowMapper;
import com.sai.spring.springjdbc.model.Employee;

@Component("employeeSpringJdbcDaoImpl")
public class EmployeeSpringJdbcDaoImpl implements EmployeeDao {

	private EmployeeRowMapper rowMapper;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> findAllEmployees() throws ClassNotFoundException, SQLException {

		rowMapper = new EmployeeRowMapper();

		// List<Employee> employees = jdbcTemplate.query("select * from employee",
		// rowMapper);
		List<Employee> employees = jdbcTemplate.query("select * from employee where exp >?", rowMapper, 0);

		return employees;
	}

	@Override
	public int insertEmployee(Employee employee) throws ClassNotFoundException, SQLException {

		String insertSql = "INSERT INTO employee (id, name, exp) VALUES (?, ?, ?)";
		int value = jdbcTemplate.update(insertSql, employee.getId(), employee.getName(), employee.getExperiance());
		return value;
	}

	@Override
	public Employee getEmployeeById(String id) {
		Employee employees = null;
		rowMapper = new EmployeeRowMapper();

		try {
			employees = jdbcTemplate.queryForObject("select * from employee where id = ?", rowMapper, id);
		} catch (EmptyResultDataAccessException e) {

			e.printStackTrace();
		}
		return employees;

	}

	@Override
	public int updateEmployeeById(String empId) {

		String sql = "update employee set name = 'salim' where id = ?";

		int value = jdbcTemplate.update(sql, empId);
		return value;

	}

	@Override
	public int deleteEmployeeById(String empId) {

		String sql = "DELETE FROM employee WHERE id = ?";
		int value = jdbcTemplate.update(sql, empId);
		return value;
	}

}
