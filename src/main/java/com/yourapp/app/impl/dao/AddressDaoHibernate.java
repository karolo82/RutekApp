package com.yourapp.app.impl.dao;

import org.springframework.stereotype.Component;

import com.yourapp.app.impl.model.entity.Address;

@Component("addressDao")
public class AddressDaoHibernate extends BaseDaoHibernate<Long, Address> implements AddressDao {

	public AddressDaoHibernate() {
		super(Address.class);
	}
	

}
