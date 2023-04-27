package com.driveinmoviecinema.models;



import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingSlot {
	
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
	@Id
	private int id;
	private String slot;
	private String movieTitle;
	private String Date;
	private String PlayTime;
	private boolean avliable; 
	
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getPlayTime() {
		return PlayTime;
	}
	public void setPlayTime(String playTime) {
		PlayTime = playTime;
	}
	public ParkingSlot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public boolean isAvliable() {
		return avliable;
	}
	public void setAvliable(boolean avliable) {
		this.avliable = avliable;
	}
	public ParkingSlot(int id, String slot, String movieTitle, String date, String playTime, boolean avliable) {
		super();
		this.id = id;
		this.slot = slot;
		this.movieTitle = movieTitle;
		Date = date;
		PlayTime = playTime;
		this.avliable = avliable;
	}
	
	
}
