package com.techelevator.model;

import java.util.List;


public interface ReservationDao {
	
	public Long saveReservation(Reservation reservation);
	
	public List<Reservation> listAllReservations();

	public Reservation getReservationById(Long reservationId);
	
}
