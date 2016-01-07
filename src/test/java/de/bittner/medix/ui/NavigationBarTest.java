package de.bittner.medix.ui;

import static org.junit.Assert.assertEquals;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import de.bittner.medix.MedixApplication;
import de.bittner.medix.pages.Start;

public class NavigationBarTest {

	private MedixApplication application;
	private WicketTester tester;

	@Before
	public void setUp() {
		application = new MedixApplication();
		tester = new WicketTester(application);
	}

	@Test
	public void rendersComponent() {
		NavigationBar navbar = new NavigationBar("nav");
		tester.startComponentInPage(navbar);
		assertEquals(navbar, tester.getComponentFromLastRenderedPage("nav"));
	}

	@Test
	public void rendersComponentWithItem() {
		NavigationBar navbar = new NavigationBar("nav");
		navbar.add(new NavigationItem(navbar.newChildId()) {

			private static final long serialVersionUID = 1L;

			@Override
			protected String getTitle() {
				return "Test";
			}

			@Override
			protected Class<? extends BasePage> getTarget() {
				return Start.class;
			}
		});
		tester.startComponentInPage(navbar);
		assertEquals(navbar, tester.getComponentFromLastRenderedPage("nav"));
	}
}
