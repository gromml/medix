package de.bittner.medix.template.tag;

import de.bittner.medix.template.Tag;

public class ListItem extends Tag {

	public ListItem(String text) {
		super("li", text);
	}

	public ListItem() {
		this(null);

	}

}
