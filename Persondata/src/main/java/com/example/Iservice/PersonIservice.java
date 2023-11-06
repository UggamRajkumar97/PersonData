package com.example.Iservice;

import java.util.List;

import com.example.Entity.Person;
import com.example.Exception.PersonException;

public interface PersonIservice {

	public Person save(Person person);
	public Person getById(Integer integer) throws PersonException;
	public List<Person> getByName(String name) throws PersonException;
	public List<Person> getAll() throws PersonException;
	public Person updateById(Integer id,Person person) throws PersonException;
	
	
}
