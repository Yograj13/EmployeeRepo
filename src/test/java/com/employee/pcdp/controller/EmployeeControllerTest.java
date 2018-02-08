package com.employee.pcdp.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.employee.pcdp.model.Employee;
import com.employee.pcdp.repository.EmployeeRepository;
import com.employee.pcdp.service.EmployeeService;
import com.employee.pcdp.utils.EmployeeTestData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EmployeeControllerTest extends EmployeeTestData {
	
	@Autowired
	private EmployeeController employeeController;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private Employee employee;
	private List<Employee> employeeList = new ArrayList<Employee>();
	private JSONObject employeeJson;
	
	@Before
	public void setUp() throws Exception{
		this.employee= setEmployee();
		this.employeeList.add(employee);
		
		Mockito.when(employeeService.findByEmployeeId(EMPLOYEE_ID)).thenReturn(employeeList);
		
		this.employeeJson = new JSONObject();
		
		employeeJson.put("employeeId", EMPLOYEE_ID);
		employeeJson.put("employeeName", EMPLOYEE_NAME);
		employeeJson.put("employeeLocation", EMPLOYEE_LOCATION);
		
	}
	
	@Test
	public void findByEmployeeId () throws Exception{
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.employeeController).build();
		
		given(this.employeeService.findByEmployeeId(EMPLOYEE_ID)).willReturn(employeeList);
		
		mockMvc.perform(get("/api/employee/"+EMPLOYEE_ID).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn().equals(employeeList);	
		
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
		@Bean
		public EmployeeController employeeController(){
			return Mockito.mock(EmployeeController.class);
		}
	}
}
