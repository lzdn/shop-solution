package com.xiangqin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangqin.domain.Person;
import com.xiangqin.repository.PersonRepository;
import com.xiangqin.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Integer addPerson(Person p) {
		personRepository.save(p);
		return p.getId();
	}

	@Override
	public List<Person> list() {
		return personRepository.findAll();
	}

	@Override
	public Person findPerson(Integer id) {
		return personRepository.getOne(id);
	}
}
