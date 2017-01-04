package com.yourapp.app.impl.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yourapp.app.api.manager.PersonManager;
import com.yourapp.app.impl.dao.PersonDao;
import com.yourapp.app.impl.model.entity.Person;

@Service
public class PersonManagerImpl implements PersonManager {

	@Autowired
	private PersonDao personDao;

	@Transactional
	public List<Person> getAll() {
		return personDao.getAll();
	}

	@Transactional
	public Long savePerson(Person person) {
		if(person.getId() ==null){
		return personDao.save(person);
		} else {
			personDao.update(person);
			return person.getId();
		}
	}

	@Transactional
	public void remove(Person person) {
		personDao.delete(person);
	}
	
	@Transactional
	public Person getPersonById(Long Id) {
		return personDao.get(Id);
	}
	
	@Transactional
	public Person getFullPersonById(Long Id) {
		return personDao.getFullPerson(Id);
	}
	
	@Transactional
	public List<Person> getPersonByCriteria(String name, String surname, String pesel) {
		if (name.isEmpty() && surname.isEmpty() && pesel.isEmpty()){
			return new ArrayList<Person>();
		}
		return personDao.getPersonByCriteria(name, surname, pesel);
	}

}
