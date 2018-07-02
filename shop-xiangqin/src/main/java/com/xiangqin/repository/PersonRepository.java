package com.xiangqin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xiangqin.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
