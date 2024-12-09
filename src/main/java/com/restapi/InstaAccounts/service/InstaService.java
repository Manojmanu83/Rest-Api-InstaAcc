package com.restapi.InstaAccounts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restapi.InstaAccounts.dto.InstaAccount;
import com.restapi.InstaAccounts.repository.InstaccountRepository;

@Service
public class InstaService {

	Map<String, Object> map = new HashMap<String, Object>();
	
	@Autowired
	InstaccountRepository instarepo;

	public ResponseEntity<Object> addInsta(InstaAccount acc,int id) {
		map.clear();
		instarepo.save(acc);
		map.put("message", "Insta account added success");
		map.put("data", acc);
		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
		}

	public ResponseEntity<Object> getAllInsta() {
		map.clear();
		List<InstaAccount> allcc = instarepo.findAll();
		if(!allcc.isEmpty()) {
			map.put("message", "Data Fetch Success");
			map.put("Data", allcc);
			return new ResponseEntity<Object>(map, HttpStatus.FOUND);
		}
		else {
			map.put("error", "NO Insta Account Found");
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Object> getInstaById(int id) {
		map.clear();
		InstaAccount acc = instarepo.findById(id).orElse(null);
		if(acc != null) {
			map.put("message", "Data Fetch Success");
			map.put("Data", acc);
			return new ResponseEntity<Object>(map, HttpStatus.FOUND);
		}
		else {
			map.put("error", "NO Insta Account Found with id " +id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Object> updateInsta(InstaAccount acc) {
		map.clear();
		if(instarepo.existsById(acc.getId())) {
			instarepo.save(acc);
			map.put("message", "Insta Updation Success");
			map.put("Data", acc);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
		else {
			map.put("error", "NO Insta Account Found with id " +acc.getId());
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Object> updateInstaById(int id, InstaAccount acc) {
		map.clear();
		if(instarepo.existsById(id)) {
			InstaAccount acc1 = instarepo.getById(id);
			if(acc.getAcc_name()!=null)
				acc1.setAcc_name(acc.getAcc_name());
			if(acc.getFollowers()!=0)
				acc1.setFollowers(acc.getFollowers());
			instarepo.save(acc1);
			map.put("message", "Insta Updation Success");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
		else {
			map.put("error", "NO Insta Account Found with id " +id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);

		}
	}

	public ResponseEntity<Object> deleteById(int id) {
		map.clear();
		if (instarepo.existsById(id)) {
			instarepo.deleteById(id);
			map.put("message", "Deletion Success");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		} else {
			map.put("error", "No Records Found in DB with id " + id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}
	}
}
