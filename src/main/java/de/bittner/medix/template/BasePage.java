package de.bittner.medix.template;

import de.bittner.medix.template.Tag.Attribute;

public class BasePage {
	private final Tag html;
	private final Tag body;

	public BasePage() {

		html = new Tag("html");
		final Tag head = new Tag("head");

		final Tag bootstrapCss = new Tag("link");
		bootstrapCss.add(new Attribute("rel", "stylesheet"));
		bootstrapCss.add(new Attribute("href", "webjars/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css"));
		head.add(bootstrapCss);
		final Tag jqueryJs = new Tag("script");
		jqueryJs.add(new Attribute("src", "webjars/jquery/2.1.4/jquery.min.js"));
		head.add(jqueryJs);
		final Tag bootstrapJs = new Tag("script");
		bootstrapJs.add(new Attribute("src", "webjars/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js"));
		head.add(bootstrapJs);

		html.add(head);
		body = new Tag("body");

		html.add(body);

	}

	public String getMarkup() {
		return html.getMarkup();
	}

	public void add(Tag tag) {
		body.add(tag);
	}

}
