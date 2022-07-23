package com.cognizant.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ems.entity.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Integer>{

}
