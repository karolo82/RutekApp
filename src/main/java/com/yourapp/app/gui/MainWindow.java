package com.yourapp.app.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.springframework.stereotype.Component;

@Component
public class MainWindow {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Zakład optyczny Paweł Rutkowski");

	}

	public void setVisible(boolean visible) {
		this.frame.setVisible(true);
	}

	public void showPanel(JPanel panel) {
		JScrollPane jsp = new JScrollPane(panel);
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		frame.getContentPane().add(jsp, BorderLayout.CENTER);
		frame.getContentPane().validate();
		

	}

}
