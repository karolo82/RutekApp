package com.yourapp.app.impl.dao;

import java.util.List;

import com.yourapp.app.impl.model.entity.Frame;

public interface FrameDao extends BaseDao<Long, Frame>{
	
	List<Frame> getFramesByCriteria(String marka, String model, String color); 
	
	List<Frame> getAllFrames();

}
