package de.bittner.medix.pages;

import java.util.Date;

import org.apache.wicket.markup.html.basic.Label;

import de.bittner.medix.ui.BasePage;

public class Start extends BasePage {

	private static final long serialVersionUID = 1L;

	public Start() {

	}

	@Override
	protected void onInitialize() {
		// TODO Auto-generated method stub
		super.onInitialize();
		Date date = new Date();
		add(new Label("message", "Hello Medix! - " + date.toString()));
	}

	@Override
	protected String getHeadline() {
		return "Start";
	}

}
