package com.techelevator.model;

import java.util.List;

public interface VenueDao {
	
	public List<Venue> listOfVenues();

	public Venue getVenueById(Long venueId);

}
