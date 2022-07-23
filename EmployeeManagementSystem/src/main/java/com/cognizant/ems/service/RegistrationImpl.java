package com.cognizant.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ems.entity.Registration;
import com.cognizant.ems.repository.RegistrationRepo;
@Service
public class RegistrationImpl implements IRegistration{
	@Autowired
	private RegistrationRepo registrationRepo;

	@Override
	public Integer saveRegistration(Registration registration) {
		// TODO Auto-generated method stub
		return registrationRepo.save(registration).getId();
	}

}
