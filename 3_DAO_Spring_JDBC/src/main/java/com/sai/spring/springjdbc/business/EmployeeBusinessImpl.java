package com.sai.spring.springjdbc.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sai.spring.springjdbc.dao.EmployeeDao;
import com.sai.spring.springjdbc.model.Employee;

@Component("employeeBusinessImpl")
public class EmployeeBusinessImpl implements EmployeeBusiness {

	@Autowired
	@Qualifier("employeeSpringJdbcDaoImpl")
	public EmployeeDao employeeDao;

	/*
	 * public EmployeeDao getEmployeeDao() { return employeeDao; }
	 * 
	 * 
	 * public void setEmployeeDao(EmployeeDao employeeDao) { this.employeeDao =
	 * employeeDao; }
	 */

	@Override
	public void printEmployeeHike() throws ClassNotFoundException, SQLException {

		List<Employee> empList = employeeDao.findAllEmployees();

		if (empList != null) {

			for (Employee employee : empList) {

				if (employee.getExperiance() >= 15) {

					System.out.println("Employee " + employee.getName() + " with Experiance " + employee.getExperiance()
							+ " ==> Got 30 % hike !!\n");
				}

				else if (employee.getExperiance() >= 10) {
					System.out.println("Employee " + employee.getName() + " with Experiance " + employee.getExperiance()
							+ " ==> Got 20 % hike !!\n");
				}

				else if (employee.getExperiance() >= 5) {
					System.out.println("Employee " + employee.getName() + " with Experiance " + employee.getExperiance()
							+ " ==> Got 15 % hike !!\n");
				}

				else {
					System.out.println("Employee " + employee.getName() + " with Experiance " + employee.getExperiance()
							+ " ==> Got 10 % hike !!\n");
				}

			}
		}
	}

	@Override
	public Employee getEmployeeById(String id) {

		return employeeDao.getEmployeeById(id);
	}

	@Override
	public int updateEmployeeById(String empId) {
		return employeeDao.updateEmployeeById(empId);
	}

	@Override
	public int deleteEmployeeById(String empId) {
		
		return employeeDao.deleteEmployeeById(empId);
	}

	@Override
	public int insertEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		
		return employeeDao.insertEmployee(employee);
		 
		
	}

}
