package com.cognizant.ems.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ems.entity.Employee;
import com.cognizant.ems.service.EmployeeServiceImpl;
import com.cognizant.ems.util.EmployeePDFExporter;
import com.lowagie.text.DocumentException;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl employeeService;

	@GetMapping(value ="/Employee/export/pdf", produces = { "application/pdf" })
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Employee> listEmployees = employeeService.getAllEmployees();
		// List<User> listUsers = service.listAll();

		EmployeePDFExporter exporter = new EmployeePDFExporter(listEmployees);
		exporter.export(response);

	}

//http://localhost:9090/addEmployee
	@PostMapping("/addEmployee")
	public Integer createEmployee(@RequestBody Employee employee) {

		Integer id = employeeService.saveEmployee(employee);

		return id;

	}

//http://localhost:9090/allEmployee
	@GetMapping("/allEmployee")

	public List<Employee> getEmployees() {

		return employeeService.getAllEmployees();
	}

	// http://localhost:9090/Employee/7
	@GetMapping("/Employee/{id}")

	public Optional<Employee> getEmployeeById(@PathVariable Integer id) {

		return employeeService.getEmployee(id);

	}

	// http://localhost:9090/deleteEmployee/7
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id) {

		ResponseEntity<Employee> employee = new ResponseEntity<>(HttpStatus.OK);
		try {
			employeeService.deleteEmployee(id);
		} catch (Exception e) {
			e.printStackTrace();
			employee = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return employee;
	}

	// http://localhost:9090/updateEmployee/4
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {

		ResponseEntity<Employee> updateEmployee = new ResponseEntity<>(HttpStatus.OK);
		try {
			employeeService.updateEmployee(employee, id);
		} catch (Exception e) {
			e.printStackTrace();
			updateEmployee = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return updateEmployee;
	}

}
