package com.restapi.InstaAccounts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.InstaAccounts.dto.Person;
import com.restapi.InstaAccounts.service.PersonService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	PersonService service;	
	
	@PostMapping("/persons")
	@Operation(summary = "Add Single Person")
	public ResponseEntity<Object> addPerson(@RequestBody Person person){
		return service.addPerson(person);
	}
	
	@PostMapping("/persons/multiple")
	@Operation(summary = "Add Multiple Person")
	public ResponseEntity<Object> addPersons(@RequestBody List<Person> person){
		return service.addPersons(person);
	}
	
	@GetMapping("/persons")
	@Operation(summary = "Fetch All The Persons")
	public ResponseEntity<Object> fetchAll(){
		return service.fetchAllPerson();
	}
	
	@GetMapping("/persons/{id}")
	@Operation(summary = "Fetch Person By Id")
	public ResponseEntity<Object> fetchById(@PathVariable int id){
		return service.fetchById(id);
	}
	
	@GetMapping("/persons/name/{name}")
	@Operation(summary = "Fetch Person By Name")
	public ResponseEntity<Object> fetchByname(@PathVariable String name){
		return service.fetchByName(name);
	}
	
	@DeleteMapping("/persons/{id}")
	@Operation(summary = "Delete Person By Id")
	public ResponseEntity<Object> deleteById(@PathVariable int id){
		return service.deleteById(id);
	}
	
	@PutMapping("/persons")
	@Operation(summary = "Update Person - PUT")
	public ResponseEntity<Object> updatePerson(@RequestBody Person person){
		return service.updatePerson(person);
	}
	
	
	
	@PatchMapping("/persons/{id}")
	@Operation(summary = "Update Person - PATCH")
	public ResponseEntity<Object> updatePerson(@PathVariable int id, @RequestBody Person person){
		return service.updatePerson(id,person);
	}
	
	@DeleteMapping("/persons/insta/{id}/{instaid}")
	@Operation(summary = "Delete Insta By Id")
	public ResponseEntity<Object> deleteInstaById(@PathVariable int id, @PathVariable int instaid){
		System.out.println(id + " " +instaid +  "*********");
		return service.deleteInstaById(id,instaid);
	}	
	
}
