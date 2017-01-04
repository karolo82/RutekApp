package com.yourapp.app.gui.panels;

import java.lang.reflect.Field;
import java.util.Map;

import javax.swing.JPanel;

import com.yourapp.app.gui.enums.PanelMode;


@SuppressWarnings("serial")
public abstract class JPanelBase extends JPanel {
	private PanelMode mode;

	protected abstract void initGUI();
	
	public void initPanel(PanelMode mode){
		initPanel(mode, null);
	}
	
	public void initPanel(PanelMode mode, Map<String, ? extends Object> params){
		setParams(params);
		setMode(mode);
		removeAll();
		invalidate();
		initGUI();
		validate();
	}

	private void setParams(Map<String, ? extends Object> params) {
		if(params == null){
			return;
		}
		for (String paramName : params.keySet()) {
			Field field;
			try {
				field = this.getClass().getDeclaredField(paramName);
			} catch (NoSuchFieldException e1) {
				throw new RuntimeException(e1);
			}

			field.setAccessible(true);

			try {
				field.set(this, params.get(paramName));
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		
		
	}
	protected PanelMode getMode() {
		return mode;
	}

	private void setMode(PanelMode mode) {
		this.mode = mode;
	}
}
