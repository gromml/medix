package de.bittner.medix.template;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasePageTest {

	private static final String MARKUP = "<html>" + "<head>"
			+ "<link rel=\"stylesheet\" href=\"webjars/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css\"></link>"
			+ "<script src=\"webjars/jquery/2.1.4/jquery.min.js\"></script>"
			+ "<script src=\"webjars/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js\"></script>" + "</head>"
			+ "<body></body>" + "</html>";

	@Test
	public void getMarkup() {
		final BasePage basePage = new BasePage();
		assertEquals(MARKUP, basePage.getMarkup());
	}
}
