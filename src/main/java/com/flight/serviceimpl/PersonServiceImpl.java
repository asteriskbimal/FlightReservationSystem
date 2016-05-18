package com.flight.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.model.Person;
import com.flight.repository.PersonRepository;
import com.flight.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public void savePerson(Person Person) {
		personRepository.save(Person);
		
	}

	public void deletePerson(Long id) {
		personRepository.delete(id);
		
	}

	public List<Person> getAllPerson() {
		return (List<Person>)personRepository.findAll();
	
	}

	public Person getOnePerson(Long id) {
		return (Person)personRepository.findOne(id);
	}

	public Person getPersonWithUsername(String username) {
		
		return (Person)personRepository.getPersonwithUsername(username);
	}

}
