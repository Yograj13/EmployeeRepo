package com.employee.pcdp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.pcdp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public List<Employee>findByEmployeeId(long employeeId);
}
