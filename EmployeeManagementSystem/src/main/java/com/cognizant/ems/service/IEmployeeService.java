package com.cognizant.ems.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.ems.entity.Employee;

public interface IEmployeeService {
	
//	Integer saveStudent(StudentEntity entityStudent);
//
//	public List<StudentEntity> getAllStudents();
//
//	Optional<StudentEntity> getStudent(Integer id);
//
//	public void deleteStudent(Integer id);
//
//	Integer updateStudent(StudentEntity entityStudent, Integer id);
	
	Integer saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	Optional<Employee> getEmployee(Integer id);
	public void deleteEmployee(Integer id);
	Integer updateEmployee(Employee employee, Integer id);
	
}
