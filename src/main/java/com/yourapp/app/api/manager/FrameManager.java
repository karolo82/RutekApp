package com.yourapp.app.api.manager;

import java.util.List;

import com.yourapp.app.impl.model.entity.Frame;

public interface FrameManager {
	
	List<Frame> getFrameByCriteria (String mark, String model, String color);
	
	Long saveFrame(Frame frame);
	
	void removeFrame (Frame frame);
	
	List<Frame> getAllFrames();
	
	Frame getFrameById(Long Id);
}
