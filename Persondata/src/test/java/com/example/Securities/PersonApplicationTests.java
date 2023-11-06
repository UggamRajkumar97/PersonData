package com.example.Securities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Entity.Person;
import com.example.Exception.PersonException;
import com.example.Repository.PersonRepo;
import com.example.ServiceIMPL.PersonIMPL;


@SpringBootTest
class PersonApplicationTests {

	@Test
	void contextLoads() {
	}
	@Mock
	private PersonRepo personRepo;

	@InjectMocks
	private PersonIMPL impl; 
	
	
	
	@Test
	public void testSave() {
		Person person=new Person(1, "Ravan", "9090909090", 22, "kkm");	
		Mockito.when(personRepo.save(person)).thenReturn(person);		
		assertEquals(person, impl.save(person)); 
		
	}
	@Test
	public void testGetById() throws PersonException { 
		Person person1=new Person(1, "Ravan", "9090909090", 22, "kkm");
		Person person2=new Person(2, "Ram", "9090909090", 22, "kkm");
		Person person3=new Person(3, "Raj", "9090909090", 22, "kkm");
		Mockito.when(personRepo.findById(person1.getPid())).thenReturn(Optional.of(person1));
		assertEquals(person1, impl.getById(person1.getPid()));
		
		
	}
	@Test
	public void testGetByIdEx() throws PersonException{
		Person person1=new Person(1, "Ravan", "9090909090", 22, "kkm");
		PersonException exception= assertThrows(PersonException.class, ()->impl.getById(person1.getPid()));
		assertEquals("no data present by the Id:: "+person1.getPid(), exception.getMessage());
	}
	@Test
	public void testGetByNameex()throws PersonException{
		Person person1=new Person(1, "Ravan", "9090909090", 22, "kkm");
		Person person2=new Person(2, "Karna", "9090909090", 22, "kkm");
		PersonException exception=assertThrows(PersonException.class, ()->impl.getByName(person1.getPname()));
		assertEquals("no data found by the name :: "+person1.getPname(), exception.getMessage());
	}
	@Test
	public void testGetByName() throws PersonException{
		Person person1=new Person(1, "Arjun", "9090909090", 22, "kkm");
		Person person2=new Person(2, "Ravan", "9090909090", 22, "kkm");
		List<Person>persons=new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		
	 	Mockito.when(personRepo.findByPname(person1.getPname())).thenReturn(persons);
		assertEquals(persons, impl.getByName(person1.getPname()));  
	}  
	
}
