package com.yourapp.app.impl.dao;

import java.util.List;

import com.yourapp.app.impl.model.entity.Person;

/**
 * Interfejs DAO odpowiedzilnego za utrwalanie klasy Person.
 */
public interface PersonDao extends BaseDao<Long, Person> {

	List<Person> getAll();
	
	Person getFullPerson(Long personId);
	
	List<Person> getPersonByCriteria(String name, String surname, String pesel);
}
