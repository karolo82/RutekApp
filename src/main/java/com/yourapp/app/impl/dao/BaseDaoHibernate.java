package com.yourapp.app.impl.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoHibernate<Key extends Serializable, Type> implements
		BaseDao<Key, Type> {
	private Class<Type> clazz;
	@Autowired
	private SessionFactory sessionFactory;

	public BaseDaoHibernate(Class<Type> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	public Type get(Key id) {
		return (Type) getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<Type> get(Collection<Key> ids) {
		Criteria criteria = getCurrentSession().createCriteria(clazz);
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();
	}

	public long save(Type type) {
		return (Long) getCurrentSession().save(type);
	}

	public void update(Type type) {
		getCurrentSession().update(type);
	}

	public void delete(Type type) {
		getCurrentSession().delete(type);
	}

	public void deleteById(Key id) {
		Type object = get(id);
		delete(object);
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
