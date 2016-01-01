package de.bittner.medix.template;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.bittner.medix.template.Tag.Attribute;

public class TagTest {

	@Test
	public void getMarkup() {
		final Tag tag = new Tag("hallo");
		tag.add(new Attribute("tag", "welt"));

		assertEquals("<hallo tag=\"welt\"></hallo>", tag.getMarkup());
	}

	@Test
	public void getRecursiveMarkup() {
		final Tag tag = new Tag("hallo");
		tag.add(new Attribute("tag", "welt"));
		final Tag tag2 = new Tag("hallo2");
		tag2.add(new Attribute("tag2", "welt2"));
		tag.add(tag2);

		assertEquals("<hallo tag=\"welt\"><hallo2 tag2=\"welt2\"></hallo2></hallo>", tag.getMarkup());
	}

}
