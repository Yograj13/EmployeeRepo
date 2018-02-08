package com.employee.pcdp.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.employee.pcdp.repository.EmployeeRepository;
import com.employee.pcdp.utils.EmployeeTestData;
import com.employee.pcdp.model.Employee;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EmployeeServiceTest extends EmployeeTestData {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private Employee employee;
	private List<Employee> employeeList= new ArrayList<Employee>();
	
	@Before
	public void setup(){
		this.employee=setEmployee();
		this.employeeList.add(this.employee);
		
	}
	@Test
	public void findByEmployeeId () throws Exception{
		when(employeeService.findByEmployeeId(EMPLOYEE_ID)).thenReturn(this.employeeList);
		assertEquals(this.employeeList, employeeService.findByEmployeeId(EMPLOYEE_ID));
		verify(employeeService).findByEmployeeId(EMPLOYEE_ID);
	}
	


	@Configuration
	static class EmployeeServiceTestConfiguration{
		@Bean
		public EmployeeService employeeService(){
			return Mockito.mock(EmployeeService.class);
		}
		@Bean
		public EmployeeRepository employeeRepository(){
			 return Mockito.mock(EmployeeRepository.class);
		}
		
	}
	
}
