package com.yourapp.app.gui.panels;

import javax.swing.JPanel;

import com.yourapp.app.gui.enums.PanelMode;

@SuppressWarnings("serial")
public class JPanelMode extends JPanel {
	private PanelMode mode;

	public PanelMode getMode() {
		return mode;
	}

	public void setMode(PanelMode mode) {
		this.mode = mode;
	}

}
