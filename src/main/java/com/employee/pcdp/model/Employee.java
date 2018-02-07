package com.employee.pcdp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.internal.NotNull;

@Entity(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="employeeId")
	@NotNull
	private long employeeId;
	@Column(name="employeeName")
	@NotNull
	private String employeeName;
	@Column(name="employeeLocation")
	@NotNull
	private String employeeLocation;
	
	public Employee(){}
	public Employee(long employeeId, String employeeName, String employeeLocation) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeLocation = employeeLocation;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeLocation() {
		return employeeLocation;
	}
	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}
	
	
}
