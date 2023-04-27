package com.driveinmoviecinema.DAO;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.driveinmoviecinema.models.BookingDetails;
import com.driveinmoviecinema.models.ParkingSlot;
import com.driveinmoviecinema.models.avaliableParkingSlots;
import com.driveinmoviecinema.repository.BookingDetailsRepositry;
import com.driveinmoviecinema.repository.ParkingSlotRepository;

@Component
public class BookingServiceDaoImpl implements BookingServiceDao {
	
	@Autowired
	private ParkingSlotRepository parkingSlotRepository;
	
	@Autowired
	private BookingDetailsRepositry bookingDetailsRepositry;

	@Override
	public avaliableParkingSlots parkingSlotAvaliability(ParkingSlot parkingSlot) {
		List<ParkingSlot> parkingSlots=parkingSlotRepository.findByDateAndPlayTimeAndAvliable(parkingSlot.getDate(), parkingSlot.getPlayTime(),true);
		if(parkingSlots.size()==0) {
			
		}
		List<String> avaliableslots=new ArrayList<>();
		for(ParkingSlot slot:parkingSlots) {
			
			avaliableslots.add(slot.getSlot());
			
		}
		
		return new avaliableParkingSlots(parkingSlot.getMovieTitle(), parkingSlot.getDate(), parkingSlot.getPlayTime(), avaliableslots);
		
	}

	@Override
	public BookingDetails BookTicket(BookingDetails bookingDetails) {
		// TODO Auto-generated method stub
		
		List<ParkingSlot> parkinglotDetails = parkingSlotRepository.findBySlotAndDateAndPlayTime(bookingDetails.getParkingSlotNumber(),bookingDetails.getMovieDate(), bookingDetails.getMoviePlayTime());
		
		if(parkinglotDetails.size()==0) {
			return new BookingDetails();
		}
		
		if(!parkinglotDetails.get(0).isAvliable()) {
			
			return new BookingDetails();
		}
		
		bookingDetails.genrateConfmId();
		bookingDetails.setTicketStatus("Booked");
		ParkingSlot parkingSlot=parkinglotDetails.get(0);
		parkingSlot.setAvliable(false);
		parkingSlotRepository.save(parkingSlot);
		return bookingDetailsRepositry.save(bookingDetails);
	}

	@Override
	public BookingDetails showBookingDetails(String id) {
		
		BookingDetails bookingDetailsOfuser= bookingDetailsRepositry.findById(id).orElse(new BookingDetails());
		
		
		if(bookingDetailsOfuser.getTicketConformationId()==null) {
			return new BookingDetails();
		}
		
		return bookingDetailsOfuser;
	}

	@Override
	public BookingDetails cancelBooking(String id) {
		
		BookingDetails bookingDetailsOfuser= bookingDetailsRepositry.findById(id).orElse(new BookingDetails());
		if(bookingDetailsOfuser.getTicketConformationId()==null) {
			return new BookingDetails();
		}
		bookingDetailsOfuser.setTicketStatus("Canceled");
		List<ParkingSlot> parkinglotDetails = parkingSlotRepository.findBySlotAndDateAndPlayTime(bookingDetailsOfuser.getParkingSlotNumber(),bookingDetailsOfuser.getMovieDate(), bookingDetailsOfuser.getMoviePlayTime());
		ParkingSlot parkingSlot=parkinglotDetails.get(0);
		parkingSlot.setAvliable(true);
		parkingSlotRepository.save(parkingSlot);
		return bookingDetailsRepositry.save(bookingDetailsOfuser);
	}

}
