package com.cognizant.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ems.entity.Registration;
import com.cognizant.ems.service.IRegistration;
@RestController
@CrossOrigin("http://localhost:4200/")
public class RegistrationController {
	@Autowired
	private IRegistration iRegistration;
	
	@PostMapping("/register")
	public ResponseEntity<String> saveRegistration(@RequestBody Registration registration) {
		ResponseEntity<String> resp=null;
		
try {
			
			if(registration==null) {
				throw new Exception("form should not be empty...");
			}else {
				Integer id = iRegistration.saveRegistration(registration);
				resp=new ResponseEntity<String>(new StringBuffer()
						.append("registration created with id ")
						.append(id)
						//.append(" saved")
						.toString(),HttpStatus.CREATED);
			}
					
					
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to process save order",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
}
