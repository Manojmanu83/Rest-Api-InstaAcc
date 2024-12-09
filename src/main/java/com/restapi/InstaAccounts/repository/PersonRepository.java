package com.restapi.InstaAccounts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.InstaAccounts.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	List<Person> findByName(String name);

}
