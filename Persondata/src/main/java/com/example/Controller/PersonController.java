package com.example.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Entity.Person;
import com.example.Exception.PersonException;
import com.example.Iservice.PersonIservice;


@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonIservice iservice;
	 
	@PostMapping("save")
	public ResponseEntity<Person> save(@Valid @RequestBody Person person1) {
		Person person= iservice.save(person1);  
		ResponseEntity<Person> entity=new ResponseEntity<Person>(person, HttpStatus.OK);
		return entity;
		
	}
	@GetMapping("getById/{integer}")
	public ResponseEntity<Person> getById(@PathVariable Integer integer) throws PersonException{
		Person person= iservice.getById(integer);
		ResponseEntity<Person> entity=new ResponseEntity<Person>(person, HttpStatus.ACCEPTED);
		return entity;
		
		
	}
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Person>> getByName(@PathVariable String name) throws PersonException{
		List<Person> list= iservice.getByName(name);
		ResponseEntity<List<Person>> entity=new ResponseEntity<>(list, HttpStatus.ACCEPTED);
		return entity;	
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Person>> getAll() throws PersonException{
		List<Person> list= iservice.getAll();
		ResponseEntity<List<Person>> entity=new ResponseEntity<>(list, HttpStatus.ACCEPTED);
		return entity;	
	}
	@PostMapping("/update/{id}")
	public ResponseEntity<Person> update(@PathVariable Integer id,@RequestBody Person person) throws PersonException{
		
		Person person2= iservice.updateById(id,person );
		ResponseEntity<Person> entity=new ResponseEntity<Person>(person2, HttpStatus.ACCEPTED);
		return entity;
		
		
	}
	
}
