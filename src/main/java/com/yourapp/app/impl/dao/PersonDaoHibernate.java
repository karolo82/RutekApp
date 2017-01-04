package com.yourapp.app.impl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.yourapp.app.impl.model.entity.Person;

@Component("personDao")
public class PersonDaoHibernate extends BaseDaoHibernate<Long, Person>
		implements PersonDao {

	public PersonDaoHibernate() {
		super(Person.class);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAll() {
		Criteria criteria = getCurrentSession().createCriteria(Person.class);
		return (List<Person>) criteria.list();
	}

	public Person getFullPerson(Long personId) {
		Person person = get(personId);
		Hibernate.initialize(person.getAdresses());
		Hibernate.initialize(person.getOrders());
		return person;
	}

	@SuppressWarnings("unchecked")
	public List<Person> getPersonByCriteria(String name, String surname,
			String pesel) {
		Criteria criteria = getCurrentSession().createCriteria(Person.class);
		if (name != null && !name.isEmpty()){
			criteria.add(Restrictions.like("name", name));
		}
		if (surname != null && !surname.isEmpty()){
			criteria.add(Restrictions.like("surname", surname));
		}
		if (pesel != null && !pesel.isEmpty()){
			criteria.add(Restrictions.like("pesel", pesel));
		}
		return (List<Person>) criteria.list();
	}
	
	
}
