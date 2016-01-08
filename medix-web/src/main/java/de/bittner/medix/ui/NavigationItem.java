package de.bittner.medix.ui;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public abstract class NavigationItem extends WebMarkupContainer {

	private static final long serialVersionUID = 1L;

	public NavigationItem(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		// setRenderBodyOnly(true);
		BookmarkablePageLink<Label> link = new BookmarkablePageLink<>("navLink", getTarget());
		link.add(new Label("navLinkTitle", getTitle()));
		add(link);
	}

	abstract protected String getTitle();

	abstract protected Class<? extends BasePage> getTarget();

}
