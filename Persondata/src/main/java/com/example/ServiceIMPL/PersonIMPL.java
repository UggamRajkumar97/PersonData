package com.example.ServiceIMPL;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Entity.Person;
import com.example.Exception.PersonException;
import com.example.Iservice.PersonIservice;
import com.example.Repository.PersonRepo;

@Service
public class PersonIMPL implements PersonIservice{

	@Autowired
	private PersonRepo personRepo;
	
	@Override
	public Person save(Person person) {
		
		Person person2=	personRepo.save(person);
		return person2;
		
	}

	@Override
	public Person getById(Integer integer) throws PersonException {
	 Optional<Person> perOptional=	personRepo.findById(integer);
	 if (perOptional.isPresent()) {
		 return perOptional.get();
	}
	 else {
		throw new PersonException("no data present by the Id:: "+integer);
	}
		
	}
 
	@Override
	public List<Person> getByName(String name) throws PersonException {
		List<Person> list=personRepo.findByPname(name);
		if (list.isEmpty()) {
			throw new PersonException("no data found by the name :: "+name);
		}
		return list;
	}


	@Override
	public List<Person> getAll() throws PersonException {
		List<Person> list=personRepo.findAll();
		if (list.isEmpty()) {
			throw new PersonException("no data found");
		}
		return list;
	}

	
	public Person updateById(Integer id,Person person) throws PersonException {
	Person person2=	personRepo.findById(id).get();
	if(person2!=null) {
		return personRepo.save(person2);
//			person2.setPname(person.getPname());
//			person2.setPage(person.getPage());
//			person2.setPadd(person.getPadd());
	}
	else {
		throw new PersonException("Data not found by this id::"+id);
	}
			
		
		
	}

}
