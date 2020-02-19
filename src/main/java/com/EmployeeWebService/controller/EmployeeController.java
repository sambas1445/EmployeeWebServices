package com.EmployeeWebService.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeWebService.dao.Repository;
import com.EmployeeWebService.model.Employee;
import com.sun.xml.fastinfoset.sax.Properties;

@RestController
public class EmployeeController {
	
	@Autowired
	Repository repo;
	@RequestMapping("")
	public HashMap<String, String> home() {
		HashMap<String, String> h = new HashMap<>();
		h.put("To fetch all employees", "http://localhost:8080/fetchEmployees");
		h.put("To fetch an employee by id", "http://localhost:8080/employee/<pass your employee id here>");
		h.put("To insert data", "http://localhost:8080/insert");
		
		return h;
	}
	
	@GetMapping("/fetchEmployees")
	public List<Employee> fetchEmployees() {
		List<Employee> allEmployees = new ArrayList<Employee>();
		allEmployees = repo.findAll();
		return allEmployees;
	}
	
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> employee(@PathVariable int id) {
		
		
		
		return repo.findById(id);
		
	}
	
	
	@PostMapping("/insert")
		public String insert(@RequestBody Employee data) {
			repo.save(data);
			return "data saved successfully";
		}
	

}
