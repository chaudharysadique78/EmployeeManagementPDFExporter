package com.cognizant.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
