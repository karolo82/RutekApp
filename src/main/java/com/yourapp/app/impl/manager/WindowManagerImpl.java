package com.yourapp.app.impl.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.yourapp.app.api.manager.WindowManager;
import com.yourapp.app.gui.MainWindow;
import com.yourapp.app.gui.Panel;
import com.yourapp.app.gui.enums.PanelMode;
import com.yourapp.app.gui.panels.JPanelBase;


@Service
public class WindowManagerImpl implements WindowManager {

	@Autowired
	private MainWindow mainWindow;
	@Autowired
	private ApplicationContext context;
	

	public void showMainWindow() {
		mainWindow.setVisible(true);
	}

	public void showPanel(Panel panel) {
		showPanel(panel, null, PanelMode.STANDARD);
	}

	public void showPanel(Panel panel, Map<String, ? extends Object> params) {
		showPanel(panel, params, PanelMode.PARAMS);
	}
	
	private void showPanel(Panel panel, Map<String, ? extends Object> params, PanelMode mode ){
		JPanelBase jPanel = context.getBean(panel.getBeanClass());
		jPanel.initPanel(mode, params);
		mainWindow.showPanel(jPanel);
	}
	
}
