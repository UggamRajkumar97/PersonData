package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.Entity.Person;
import com.example.Exception.PersonException;

public interface PersonRepo extends JpaRepository<Person, Integer>{

	@Query("from Person where pname=?1")
	public List<Person> findByPname(String name) throws PersonException;
	
//	@Modifying
//	@Transactional
//	@Query("update Person set pname=:pname where pid=:pid")
//	public Integer updateById(Long pid,Person person);
	
}
