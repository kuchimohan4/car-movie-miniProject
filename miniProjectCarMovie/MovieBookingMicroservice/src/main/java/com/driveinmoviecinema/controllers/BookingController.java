package com.driveinmoviecinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driveinmoviecinema.Service.BookingService;
import com.driveinmoviecinema.exception.noSlotsFoundException;
import com.driveinmoviecinema.models.BookingDetails;
import com.driveinmoviecinema.models.ParkingSlot;
import com.driveinmoviecinema.models.avaliableParkingSlots;



@RestController
@RequestMapping("/Booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/ParkingSlots")
	public avaliableParkingSlots  parkingSlotAvaliability(@RequestBody ParkingSlot parkingSlot) throws noSlotsFoundException {
		return bookingService.parkingSlotAvaliability(parkingSlot);
	}
	@PostMapping("/BookTicket")
	public BookingDetails BookTicket(@RequestBody BookingDetails bookingDetails)throws noSlotsFoundException {
		
		return bookingService.BookTicket(bookingDetails);
	}
	@GetMapping("/viewBookingDetails/{id}")
	public BookingDetails showBookingDetails(@PathVariable String id)throws noSlotsFoundException {
		
		return bookingService.showBookingDetails(id);	
	}
	@DeleteMapping("/CancelBooking/{id}")
	public BookingDetails cancelBooking(@PathVariable String id) throws noSlotsFoundException {
		
		
		return bookingService.cancelBooking(id);
	}
	
	@ExceptionHandler
	public String exceptionHandeler(Exception ex) {
		return ex.getMessage();
		
	}
	

}
