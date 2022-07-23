package com.cognizant.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cognizant.ems.constant.Designation;
import com.cognizant.ems.constant.Gender;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eid;
	private String ename;
	
	//@Enumerated(EnumType.STRING)
	@Column(name="Designation")
	//private Designation edesignation;
	private String edesignation;
	
	private Integer eage;
	private String email;
	
	//@Enumerated(EnumType.STRING)
	@Column(name="Gender")
	//private Gender egender;

	private String egender;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer eid, String ename, String edesignation, Integer eage, String email, String egender) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.edesignation = edesignation;
		this.eage = eage;
		this.email = email;
		this.egender = egender;
	}


	public Integer getEid() {
		return eid;
	}

	public String getEname() {
		return ename;
	}

	
	public Integer getEage() {
		return eage;
	}

	public String getEmail() {
		return email;
	}

	
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	

	public void setEage(Integer eage) {
		this.eage = eage;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	





	public String getEdesignation() {
		return edesignation;
	}

	public void setEdesignation(String edesignation) {
		this.edesignation = edesignation;
	}

	public String getEgender() {
		return egender;
	}

	public void setEgender(String egender) {
		this.egender = egender;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", edesignation=" + edesignation + ", eage=" + eage
				+ ", email=" + email + ", egender=" + egender + "]";
	}



}
