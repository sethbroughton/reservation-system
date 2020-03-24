package com.techelevator.model;

import java.util.List;


public interface ReservationDao {
	
	public void saveReservation(Reservation reservation);
	
	public List<Reservation> listAllReservations();

	public Reservation getReservationById(Long reservationId);
	
}
