package de.bittner.medix.pages;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagException;

import de.bittner.medix.ui.BasePage;

public class Music extends BasePage {

	private static final long serialVersionUID = 1L;

	@Override
	protected String getHeadline() {
		return "Music";
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		String testFileUrl = "/home/wbittner/Musik/Bravo Hits, Vol. 91";
		File dir = new File(testFileUrl);
		List<File> fileList = Arrays.asList(dir.listFiles());
		fileList.sort((File a, File b) -> {
			try {
				org.jaudiotagger.tag.Tag tagA = getTagFromFile(a);
				org.jaudiotagger.tag.Tag tagB = getTagFromFile(b);
				return Integer.parseInt(tagA.getFirst(FieldKey.TRACK))
						- Integer.parseInt(tagB.getFirst(FieldKey.TRACK));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
		});
		ListView<File> listView = new ListView<File>("listview", fileList) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<File> file) {
				try {
					org.jaudiotagger.tag.Tag tag = getTagFromFile(file.getModelObject());
					file.add(new Label("label", tag.getFirst(FieldKey.TRACK) + " - " + tag.getFirst(FieldKey.TITLE)));
				} catch (CannotReadException | IOException | TagException | ReadOnlyFileException
						| InvalidAudioFrameException e) {
					e.printStackTrace();
				}

			}

		};
		add(listView);
	}

	private org.jaudiotagger.tag.Tag getTagFromFile(File file)
			throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
		AudioFile audioFile = AudioFileIO.read(file);
		org.jaudiotagger.tag.Tag tag = audioFile.getTag();
		return tag;
	}

}
