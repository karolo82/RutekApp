package com.yourapp.app.impl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.yourapp.app.impl.model.entity.Frame;

@Component("frameDao")
public class FrameDaoHibernate extends BaseDaoHibernate<Long, Frame> implements FrameDao{

	public FrameDaoHibernate() {
		super(Frame.class);
	}

	@SuppressWarnings("unchecked")
	public List<Frame> getFramesByCriteria(String mark, String model,
			String color) {
			Criteria criteria = getCurrentSession().createCriteria(Frame.class);
			if (mark != null && !mark.isEmpty()){
				criteria.add(Restrictions.like("mark", mark));
			}
			if (model != null && !model.isEmpty()){
				criteria.add(Restrictions.like("model", model));
			}
			if (color != null && !color.isEmpty()){
				criteria.add(Restrictions.like("color", color));
			}
			return (List<Frame>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Frame> getAllFrames() {
		Criteria criteria = getCurrentSession().createCriteria(Frame.class);
		return (List<Frame>) criteria.list();
	}

}
