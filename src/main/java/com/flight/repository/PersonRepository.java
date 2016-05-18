package com.flight.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.model.Flight;
import com.flight.model.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

	@Query("from Person a where a.user.userName=:username")
	public List<Flight> getPersonwithUsername(@Param("username") String username);
}
