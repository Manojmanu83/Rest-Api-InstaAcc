package com.restapi.InstaAccounts.Controller;

import java.util.HashMap;
import java.util.Map;

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

import com.restapi.InstaAccounts.dto.InstaAccount;
import com.restapi.InstaAccounts.service.InstaService;

@RestController
@RequestMapping("/api/insta/")
public class InstaAccController {
	
	@Autowired
	InstaService instaservice;
	
	@PostMapping("/addInsta")
	public ResponseEntity<Object> addInsta(@RequestBody InstaAccount acc,int id) {
	    return instaservice.addInsta(acc, id);
	}
	
	@GetMapping("/getInsta")
	public ResponseEntity<Object> getAllInsta() {
	    return instaservice.getAllInsta();
	}
	
	@GetMapping("/getInsta/{id}")
	public ResponseEntity<Object> getInstaById(@PathVariable int id) {
	    return instaservice.getInstaById(id);
	}
	
	@PutMapping("/updateInsta")
	public ResponseEntity<Object> getInstaById(@RequestBody InstaAccount acc) {
	    return instaservice.updateInsta(acc);
	}
	
	@PatchMapping("/getInsta/{id}")
	public ResponseEntity<Object> updateInstaById(@PathVariable int id, @RequestBody InstaAccount acc) {
	    return instaservice.updateInstaById(id,acc);
	}
	
	@DeleteMapping("/deleteInsta/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id) {
	    return instaservice.deleteById(id);
	}
    
}
