package com.cognizant.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ems.entity.Employee;
import com.cognizant.ems.exception.ResourceNotFoundException;
import com.cognizant.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	EmployeeRepository  employeeRepository ;


	@Override
	public Integer saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		  Employee saveEmp = employeeRepository.save(employee);
		  
		  return saveEmp.getEid();
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Optional<Employee> getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}


	@Override
	public void deleteEmployee(Integer id) {
		 employeeRepository.deleteById(id);
	}


	@Override
	public Integer updateEmployee(Employee employee, Integer id) {
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("student","name","with id"+id+" not found"));
		existingEmployee.setEname(employee.getEname());
		existingEmployee.setEdesignation(employee.getEdesignation());
		existingEmployee.setEage(employee.getEage());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setEgender(employee.getEgender());
		
		employeeRepository.save(existingEmployee);
		
		return existingEmployee.getEid();
		

	}

}
