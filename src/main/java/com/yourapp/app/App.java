package com.yourapp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.yourapp.app.api.manager.WindowManager;
import com.yourapp.app.gui.Panel;

@Component
public class App {

	@Autowired
	private WindowManager windowManager;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/rutekConfig.xml");

		App p = context.getBean(App.class);
		p.start();
	}

	private void start() {
		windowManager.showMainWindow();
		windowManager.showPanel(Panel.PERSON_SEARCH);
	}
}
