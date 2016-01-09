package de.bittner.persistance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TRACKS")
public class Track {

	private Long id, track;

	public Track() {

	}

	public Track(Long track, String title) {
		super();
		this.track = track;
		this.title = title;
	}

	private String title;

	@Id
	@GeneratedValue
	@GenericGenerator(name = "increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public Long getTrack() {
		return track;
	}

	public void setTrack(Long track) {
		this.track = track;
	}

	@Column
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
