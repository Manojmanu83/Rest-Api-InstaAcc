package com.restapi.InstaAccounts.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.text.DefaultEditorKit.InsertTabAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restapi.InstaAccounts.dto.InstaAccount;
import com.restapi.InstaAccounts.dto.Person;
import com.restapi.InstaAccounts.repository.InstaccountRepository;
import com.restapi.InstaAccounts.repository.PersonRepository;

@Service
public class PersonService {

	Map<String, Object> map = new HashMap<String, Object>();

	@Autowired
	PersonRepository repo;

	@Autowired
	InstaccountRepository instarepo;

	// AddObj
	public ResponseEntity<Object> addPerson(Person person) {
		map.clear();
		if (person != null) {
			repo.save(person);
			map.put("message", "Person Added Success");
			map.put("Details", person);
			return new ResponseEntity<Object>(map, HttpStatus.CREATED);
		} else {
			map.put("message", "No Proper values provoided for adding object");
			return new ResponseEntity<Object>(map, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	// Add Mulitple Obj
	public ResponseEntity<Object> addPersons(List<Person> person) {
		map.clear();
		if (person != null) {
			repo.saveAll(person);
			map.put("message", "Persons Added Success");
			map.put("Details", person);
			return new ResponseEntity<Object>(map, HttpStatus.CREATED);
		} else {
			map.put("message", "No Proper values provoided for adding object");
			return new ResponseEntity<Object>(map, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	// fetchAll
	public ResponseEntity<Object> fetchAllPerson() {
		map.clear();
		List<Person> persons = repo.findAll();
		if (!persons.isEmpty()) {
			map.put("message", "Fetch success");
			map.put("Details", persons);
			return new ResponseEntity<Object>(map, HttpStatus.FOUND);
		} else {
			map.put("error", "No Records Found in DB");
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}
	}

//	fetchById
	public ResponseEntity<Object> fetchById(int id) {
		map.clear();
		Optional<Person> person = repo.findById(id);
		if (person.isPresent()) {
			map.put("message", "Data found");
			map.put("Data", person);
			return new ResponseEntity<Object>(map, HttpStatus.FOUND);
		} else {
			map.put("error", "No Records Found in DB" + id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Object> fetchByName(String name) {
		map.clear();
		List<Person> person = repo.findByName(name);
		if (!person.isEmpty()) {
			map.put("message", "Data found");
			map.put("Data", person);
			return new ResponseEntity<Object>(map, HttpStatus.FOUND);
		} else {
			map.put("error", "No Records Found in DB" + name);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}
	}

	// deletebyid
	public ResponseEntity<Object> deleteById(int id) {
		map.clear();
		if (repo.existsById(id)) {
			repo.deleteById(id);
			map.put("message", "Deletion Success");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		} else {
			map.put("error", "No Records Found in DB with id " + id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}

	}

	// put update
	public ResponseEntity<Object> updatePerson(Person person) {
		map.clear();
		if (person != null) {
			repo.save(person);
			map.put("message", "Person Updation Success");
			map.put("Details", person);
			return new ResponseEntity<Object>(map, HttpStatus.CREATED);
		} else {
			map.put("message", "No Proper values provoided for adding object");
			return new ResponseEntity<Object>(map, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	// Patch Update
	public ResponseEntity<Object> updatePerson(int id, Person person) {
		map.clear();
		Person person1 = repo.findById(id).orElseThrow();
		if (person != null) {
			if (person.getName() != null)
				person1.setName(person.getName());
			if (person.getAge() != 0)
				person1.setAge(person.getAge());
			if (person.getInstaacc() != null)
				person1.setInstaacc(person.getInstaacc());

			repo.save(person1);
			map.put("message", "Person Updation Success");
			map.put("Details", person1);
			return new ResponseEntity<Object>(map, HttpStatus.CREATED);
		} else {
			map.put("message", "No Proper values provoided for adding object");
			return new ResponseEntity<Object>(map, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	public ResponseEntity<Object> deleteInstaById(int id, int instaid) {
		map.clear();
		System.out.println(id + " " +instaid +  "****2****");
		Person person = repo.findById(id).orElse(null);
		if (person != null) {
			List<InstaAccount> instaac = person.getInstaacc();
			System.out.println(id + " " +instaid +  "****3****");
			if (!instaac.isEmpty()) {
				Iterator<InstaAccount> i = instaac.iterator();
				System.out.println(id + " " +instaid +  "****4****");
				{
					if (instarepo.existsById(instaid)) {
						System.out.println(id + " "+instaid +  "****5****");
						while (i.hasNext()) { 
							if (i.next().getId() == instaid) {
								i.remove();
							}
						}
					} else {
						map.put("error", "No InstaAccounts Found with id " + instaid);
						return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
					}
					repo.save(person);
//		    		person.setInstaacc(instaac);
				}
				map.put("message", "Deletion Success");
				return new ResponseEntity<Object>(map, HttpStatus.OK);
			} else {
				map.put("error", "No InstaAccounts Found for the user with id " + id);
				return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
			}
		} else {
			map.put("error", "Person not Found with id " + id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}

	}

}

//if(!person.getInstaacc().isEmpty()) {
//List<InstaAccount> insta = person.getInstaacc();
//for(InstaAccount ia : insta) {
//	if(person.getInstaacc().get(id) == insta.get(id)) {
//		if(insta.get(id).getAcc_name()!=null)
//			person1.setInstaacc(insta);
//	}
//}	
//}
