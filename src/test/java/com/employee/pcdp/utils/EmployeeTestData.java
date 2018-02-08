package com.employee.pcdp.utils;

import com.employee.pcdp.model.Employee;

public class EmployeeTestData {
	protected static final Long EMPLOYEE_ID=1L;
	protected static final String EMPLOYEE_NAME="Raj Malhotra";
	protected static final String EMPLOYEE_LOCATION="Banglore";
	
	protected static Employee setEmployee(){
		Employee employee = new Employee();
		employee.setEmployeeId(EMPLOYEE_ID);
		employee.setEmployeeName(EMPLOYEE_NAME);
		employee.setEmployeeLocation(EMPLOYEE_LOCATION);
		return employee;
	}

}
