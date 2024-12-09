package com.restapi.InstaAccounts.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_per_id", referencedColumnName = "id")
	private List<InstaAccount> instaacc;
}
