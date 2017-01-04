package com.yourapp.app.api.manager;

import java.util.List;

import com.yourapp.app.impl.model.entity.Order;
import com.yourapp.app.impl.model.entity.Person;

public interface OrderManager {

	List<Order> getAll();
	
	Long saveOrder(Order order);
	
	void removeOrder(Order order);
	
	List<Order> getPersonOrders(Person person);
	
	Integer getMaxOrderNumber();
	
	Order getOrderById(Long id);
}
