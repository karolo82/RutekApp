package com.yourapp.app.api.manager;

import java.util.List;

import com.yourapp.app.impl.model.entity.Person;

public interface PersonManager {

	List<Person> getAll();

	void remove(Person person);
	
	Long savePerson (Person person);
	
	Person getPersonById(Long Id);
	
	Person getFullPersonById(Long Id); 
	
	List<Person> getPersonByCriteria(String name, String surname, String pesel);
	
}
