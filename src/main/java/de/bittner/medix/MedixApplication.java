package de.bittner.medix;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import de.bittner.medix.pages.Start;

public class MedixApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return Start.class;
	}

}
