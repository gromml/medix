package de.bittner.medix.entities;

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
	private String title;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	@Column
	public Long getTrack() {
		return track;
	}

	@Column
	public String getTitle() {
		return title;
	}
}
