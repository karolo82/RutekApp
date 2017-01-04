package com.yourapp.app.impl.dao;

import java.util.List;

import com.yourapp.app.impl.model.entity.Order;
import com.yourapp.app.impl.model.entity.Person;

public interface OrderDao extends BaseDao<Long, Order>{

	List<Order> getAll();
	
	List<Order> getPersonOrders(Person person);
	
	//Order getOrderById(Long id);
	
	Integer getMaxOrderNumber();
}
