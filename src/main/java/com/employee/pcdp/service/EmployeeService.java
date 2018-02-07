package com.employee.pcdp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.pcdp.model.Employee;
import com.employee.pcdp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findByEmployeeId(long employeeId){
		return employeeRepository.findByEmployeeId(employeeId);
	}
	public Employee captureEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	public Employee updateEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	public void deleteEmployee(long employeeId){
		Employee employee= employeeRepository.findOne(employeeId);
		if(employee!=null){
			employeeRepository.delete(employee);
		 }
	} 
}
