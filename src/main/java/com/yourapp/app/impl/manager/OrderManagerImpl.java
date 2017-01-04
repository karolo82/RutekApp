package com.yourapp.app.impl.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yourapp.app.api.manager.OrderManager;
import com.yourapp.app.impl.dao.OrderDao;
import com.yourapp.app.impl.model.entity.Order;
import com.yourapp.app.impl.model.entity.Person;

@Service
public class OrderManagerImpl implements OrderManager {

	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	public List<Order> getAll() {
		return orderDao.getAll();
	}

	@Transactional
	public Long saveOrder(Order order) 
	{
		if(order.getId() == null)
		{
			return orderDao.save(order);
		}
		else
		{
			orderDao.update(order);
			return order.getId();
		}
	}

	@Transactional
	public void removeOrder(Order order) {
		orderDao.delete(order);

	}

	@Transactional
	public List<Order> getPersonOrders(Person person) {
		return orderDao.getPersonOrders(person);
	}

	@Transactional
	public Integer getMaxOrderNumber() {
		return orderDao.getMaxOrderNumber();
	}
	
	@Transactional
	public Order getOrderById(Long id) {
		return orderDao.get(id);
	}

}
