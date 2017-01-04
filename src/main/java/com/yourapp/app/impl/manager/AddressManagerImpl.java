package com.yourapp.app.impl.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yourapp.app.api.manager.AddressManager;
import com.yourapp.app.impl.dao.AddressDao;
import com.yourapp.app.impl.model.entity.Address;
@Service
public class AddressManagerImpl implements AddressManager {

	@Autowired
	private AddressDao addressDao;
	
	@Transactional
	public Long addAddress(Address address) {
		return addressDao.save(address);
	}

}
