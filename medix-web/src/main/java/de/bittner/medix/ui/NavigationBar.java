package de.bittner.medix.ui;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

import de.bittner.medix.MedixApplication;

public class NavigationBar extends Panel {

	private static final long serialVersionUID = 1L;
	private RepeatingView navItems;

	public NavigationBar(String id) {
		super(id);
		add(new Label("brand", MedixApplication.APPLICATION_NAME));
		navItems = new RepeatingView("navItem");
		add(navItems);
	}

	public void add(NavigationItem item) {
		navItems.add(item);
	}

	public String newChildId() {
		return navItems.newChildId();
	}

}
