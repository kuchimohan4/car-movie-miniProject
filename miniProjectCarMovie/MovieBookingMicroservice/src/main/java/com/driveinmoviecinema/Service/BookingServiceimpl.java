package com.driveinmoviecinema.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driveinmoviecinema.DAO.BookingServiceDao;
import com.driveinmoviecinema.models.BookingDetails;
import com.driveinmoviecinema.models.ParkingSlot;

@Service
public class BookingServiceimpl implements BookingService {

	@Autowired
	private BookingServiceDao bookingServiceDao;
	
	@Override
	public ParkingSlot parkingSlotAvaliability(ParkingSlot parkingSlot) {
		// TODO Auto-generated method stub
		return bookingServiceDao.parkingSlotAvaliability(parkingSlot);
	}
	
	@Override
	public BookingDetails BookTicket(BookingDetails bookingDetails) {
		// TODO Auto-generated method stub
		return bookingServiceDao.BookTicket(bookingDetails);
	}

	@Override
	public BookingDetails showBookingDetails(String id) {
		// TODO Auto-generated method stub
		return bookingServiceDao.showBookingDetails(id);
	}

	@Override
	public BookingDetails cancelBooking(String id) {
		// TODO Auto-generated method stub
		return bookingServiceDao.cancelBooking(id);
	}

	

}
