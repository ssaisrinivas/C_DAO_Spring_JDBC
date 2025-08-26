package com.sai.spring.springjdbc.application;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sai.spring.springjdbc.business.EmployeeBusiness;
import com.sai.spring.springjdbc.model.Employee;

public class Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ApplicationContext context = new ClassPathXmlApplicationContext("configmetadataspringjdbc.xml");

		EmployeeBusiness employeeBusiness = (EmployeeBusiness) context.getBean("employeeBusinessImpl");

		/*
		 * int insetValue = employeeBusiness.insertEmployee(new Employee("210",
		 * "Langul", 20));
		 * 
		 * if (insetValue == 0) {
		 * 
		 * System.out.println("Employee Not record inserted"); } else {
		 * System.out.println("Employee record inserted"); }
		 */

		employeeBusiness.printEmployeeHike();

		int updateValue = employeeBusiness.updateEmployeeById("190");

		if (updateValue == 0) {

			System.out.println("Employee record Not updated");
		} else {
			System.out.println("Employee record updated");
		}

		int deleteValue = employeeBusiness.deleteEmployeeById("129");

		if (deleteValue == 0) {

			System.out.println("Employee record Not deleted");
		} else {
			System.out.println("Employee record deleted");
		}

		Employee emp = employeeBusiness.getEmployeeById("100");

		if (emp != null) {

			System.out.println("Employee Name : " + emp.getName() + "\nEmployee Experiance : " + emp.getExperiance());
		}

		else {
			System.out.println("There is no matching record found");
		}

	}

}
