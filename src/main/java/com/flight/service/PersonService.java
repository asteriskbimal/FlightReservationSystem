package com.flight.service;

import java.util.List;

import com.flight.model.Person;

public interface PersonService {

	public void savePerson(Person Person);
	public void deletePerson(Long id);
	public List<Person> getAllPerson();
	public Person getOnePerson(Long id);
	public Person getPersonWithUsername(String username);
}
