package com.driveinmoviecinema.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookingDetails {
	
	@Id
	private String TicketConformationId;
	private String carNumber;
	private String movieTitle;
	private String movieDate;
	private String moviePlayTime;
	private String ParkingSlotNumber;
	private String TicketStatus;
	
	public String getTicketConformationId() {
		return TicketConformationId;
	}
	public void setTicketConformationId(String ticketConformationId) {
		TicketConformationId = ticketConformationId;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}
	public String getMoviePlayTime() {
		return moviePlayTime;
	}
	public void setMoviePlayTime(String moviePlayTime) {
		this.moviePlayTime = moviePlayTime;
	}
	public String getParkingSlotNumber() {
		return ParkingSlotNumber;
	}
	public void setParkingSlotNumber(String parkingSlotNumber) {
		ParkingSlotNumber = parkingSlotNumber;
	}
	public String getTicketStatus() {
		return TicketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		TicketStatus = ticketStatus;
	}
	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookingDetails(String ticketConformationId, String carNumber, String movieTitle, String movieDate,
			String moviePlayTime, String parkingSlotNumber, String ticketStatus) {
		super();
		TicketConformationId = ticketConformationId;
		this.carNumber = carNumber;
		this.movieTitle = movieTitle;
		this.movieDate = movieDate;
		this.moviePlayTime = moviePlayTime;
		ParkingSlotNumber = parkingSlotNumber;
		TicketStatus = ticketStatus;
	}
	
	
	

}
