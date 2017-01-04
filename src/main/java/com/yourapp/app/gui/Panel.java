package com.yourapp.app.gui;

import com.yourapp.app.gui.panels.FrameAddPanel;
import com.yourapp.app.gui.panels.FrameSearchPanel;
import com.yourapp.app.gui.panels.JPanelBase;
import com.yourapp.app.gui.panels.OrderAdd;
import com.yourapp.app.gui.panels.PersonAdd;
import com.yourapp.app.gui.panels.PersonAddPanel;
import com.yourapp.app.gui.panels.PersonSearch;

public enum Panel {
	PERSON_SEARCH(PersonSearch.class), 
	PERSON_ADD(PersonAdd.class), 
	PERSON_ADD_PANEL(PersonAddPanel.class), 
	ORDER_ADD(OrderAdd.class),
	FRAME_SEARCH(FrameSearchPanel.class), 
	FRAME_ADD(FrameAddPanel.class);

	private Class<? extends JPanelBase> beanClass;

	private Panel(Class<? extends JPanelBase> beanClass) {
		this.beanClass = beanClass;
	}

	public Class<? extends JPanelBase> getBeanClass() {
		return beanClass;
	}
}
