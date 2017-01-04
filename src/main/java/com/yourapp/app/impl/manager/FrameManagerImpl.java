package com.yourapp.app.impl.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yourapp.app.api.manager.FrameManager;
import com.yourapp.app.impl.dao.FrameDao;
import com.yourapp.app.impl.model.entity.Frame;

@Service
public class FrameManagerImpl implements FrameManager{

	@Autowired
	private FrameDao frameDao;
	
	@Transactional
	public List<Frame> getFrameByCriteria(String mark, String model,
			String color) {
		if (!mark.isEmpty() || !model.isEmpty() || !color.isEmpty()){
			return frameDao.getFramesByCriteria(mark, model, color);
		}
		return new ArrayList<Frame>();
	}
	
	@Transactional
	public Long saveFrame(Frame frame) {
		if (frame.getId() == null){
			return frameDao.save(frame);
		}else{
			frameDao.update(frame);
			return frame.getId();
		}
	}
	
	@Transactional
	public void removeFrame(Frame frame) {
		frameDao.delete(frame);
	}

	@Transactional
	public List<Frame> getAllFrames() {
		return frameDao.getAllFrames();
	}
	
	@Transactional
	public Frame getFrameById(Long Id) {
		return frameDao.get(Id);
	}
}
