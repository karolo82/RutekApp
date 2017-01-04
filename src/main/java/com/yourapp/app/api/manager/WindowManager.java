package com.yourapp.app.api.manager;

import java.util.Map;

import com.yourapp.app.gui.Panel;

public interface WindowManager {

	void showMainWindow();

	void showPanel(Panel panel);

	void showPanel(Panel panel, Map<String, ? extends Object> params);

}
