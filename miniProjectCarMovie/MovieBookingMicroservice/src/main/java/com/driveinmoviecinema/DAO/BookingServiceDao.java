package com.driveinmoviecinema.DAO;

import com.driveinmoviecinema.models.BookingDetails;
import com.driveinmoviecinema.models.ParkingSlot;
import com.driveinmoviecinema.models.avaliableParkingSlots;

public interface BookingServiceDao {
	
	public avaliableParkingSlots parkingSlotAvaliability(ParkingSlot parkingSlot);

	public BookingDetails BookTicket(BookingDetails bookingDetails);

	public BookingDetails showBookingDetails(String id);

	public BookingDetails cancelBooking(String id);

}
