package com.xiangqin.service;

import java.util.List;

import com.xiangqin.domain.Person;

public interface PersonService {

	Integer addPerson(Person p);
	
	List<Person> list();
	
	Person findPerson(Integer id);
	
}
