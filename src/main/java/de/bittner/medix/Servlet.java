package de.bittner.medix;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagException;

import de.bittner.medix.template.BasePage;
import de.bittner.medix.template.Tag;
import de.bittner.medix.template.tag.ListItem;
import de.bittner.medix.template.tag.UnsortedList;

//@WebServlet("/medix")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BasePage basePage;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		basePage = new BasePage();
		Tag headline = new Tag("h1", "Hallo Medix!");
		basePage.add(headline);

		// String testFileUrl = "E:/TestMusik/source/ASD/Wer hätte das Gedacht/01 - ASD - Intro.mp3";
		String testFileUrl = "E:/TestMusik/source/ASD/Wer hätte das Gedacht";
		File dir = new File(testFileUrl);
		UnsortedList list = new UnsortedList();

		for (File file : dir.listFiles()) {
			try {
				AudioFile audioFile = AudioFileIO.read(file);
				org.jaudiotagger.tag.Tag tag = audioFile.getTag();
				list.add(new ListItem(tag.getFirst(FieldKey.TRACK) + " - " + tag.getFirst(FieldKey.TITLE)));
			} catch (CannotReadException | TagException | ReadOnlyFileException | InvalidAudioFrameException e) {
				e.printStackTrace();
			}
		}

		basePage.add(list);
		out.println(basePage.getMarkup());
	}
}
