package com.yourapp.app.impl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.yourapp.app.impl.model.entity.Order;
import com.yourapp.app.impl.model.entity.Person;

@Component("orderDao")
public class OrderDaoHibernate extends BaseDaoHibernate<Long, Order> implements OrderDao{

	public OrderDaoHibernate() {
		super(Order.class);
	}

	@SuppressWarnings("unchecked")
	public List<Order> getAll() {
		Criteria criteria = getCurrentSession().createCriteria(Order.class);
		return (List<Order>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Order> getPersonOrders(Person person) {
		if(person ==null){
			return null;
		}
		Criteria criteria = getCurrentSession().createCriteria(Order.class);
		criteria.add(Restrictions.eq("person",person));
		return (List<Order>) criteria.list();
	}

	public Integer getMaxOrderNumber() {
		Criteria criteria = getCurrentSession().createCriteria(Order.class).setProjection(Projections.max("orderNumber"));
		Integer nextOrderNumber = (Integer)criteria.uniqueResult();
		if(nextOrderNumber == null){
			nextOrderNumber = 1;
		}else{
			nextOrderNumber += 1;
		}
		return nextOrderNumber;
	}
	
	

}
