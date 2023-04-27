package com.driveinmoviecinema.Service;

import com.driveinmoviecinema.models.BookingDetails;
import com.driveinmoviecinema.models.ParkingSlot;

public interface BookingService {
	
	
	public ParkingSlot parkingSlotAvaliability(ParkingSlot parkingSlot);

	public BookingDetails BookTicket(BookingDetails bookingDetails);

	public BookingDetails showBookingDetails(String id);

	public BookingDetails cancelBooking(String id);

}
