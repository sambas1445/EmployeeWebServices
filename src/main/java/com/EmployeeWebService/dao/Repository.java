package com.EmployeeWebService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeWebService.model.Employee;

@org.springframework.stereotype.Repository
public  interface Repository extends JpaRepository<Employee, Integer>{
	
	

}
