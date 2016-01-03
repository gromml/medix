package de.bittner.medix.ui;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public abstract class BasePage extends WebPage {

	private static final long serialVersionUID = 1L;
	private static final String BOOTSTRAP_VERSION = "4.0.0-alpha.2";
	private static final String JQUERY_VERSION = "2.1.4";

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("headline", getHeadline()));
		add(new Label("title", getHeadline() + " - medix"));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(
				CssReferenceHeaderItem.forUrl("webjars/bootstrap/" + BOOTSTRAP_VERSION + "/css/bootstrap.min.css"));

		response.render(JavaScriptReferenceHeaderItem.forUrl("webjars/jquery/" + JQUERY_VERSION + "/jquery.min.js"));

		response.render(JavaScriptReferenceHeaderItem
				.forUrl("webjars/bootstrap/" + BOOTSTRAP_VERSION + "/js/bootstrap.min.js"));

	}

	abstract protected String getHeadline();
}
