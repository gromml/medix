package de.bittner.medix.template;

import java.util.ArrayList;
import java.util.List;

public class Tag {

	private final String name, text;
	private final List<Attribute> attributes = new ArrayList<Attribute>();
	private final List<Tag> content = new ArrayList<Tag>();

	public Tag(String name) {
		this(name, null);
	}

	public Tag(String name, String text) {
		super();
		this.name = name;
		this.text = text;
	}

	public void add(Attribute attribute) {
		attributes.add(attribute);
	}

	public void add(Tag tag) {
		content.add(tag);
	}

	public String getMarkup() {
		final StringBuilder markup = new StringBuilder();
		markup.append("<" + name);
		for (final Attribute attribute : attributes) {
			markup.append(attribute.getMarkup());
		}
		markup.append(">");
		if (text != null) {
			markup.append(text);
		}
		for (final Tag tag : content) {
			markup.append(tag.getMarkup());
		}
		markup.append("</" + name + ">");
		return markup.toString();
	}

	public static class Attribute {
		private String key;
		private String value;

		public Attribute(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getMarkup() {
			return " " + getKey() + "=\"" + getValue() + "\"";
		}
	}
}
