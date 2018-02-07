package com.employee.pcdp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.pcdp.model.Employee;
import com.employee.pcdp.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/{employeeId}", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> findByEmployeeId(@PathVariable ("employeeId") long employeeId){
		return employeeService.findByEmployeeId(employeeId);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json")
	public Employee captureEmployee( @RequestBody Employee employee){
		return employeeService.captureEmployee(employee);
	}
	@RequestMapping(value="/update",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json")
	public Employee updateEmployee( @RequestBody Employee employee){
		return employeeService.updateEmployee(employee);
	}
	@RequestMapping(value="/delete/{employeeId}",method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json")
	public void deleteEmployee( @PathVariable(value = "employeeId") long employeeId){
		 employeeService.deleteEmployee(employeeId);
	}
}
