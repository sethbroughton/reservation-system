package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCVenueDao implements VenueDao{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCVenueDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Venue> listOfVenues() {
		List<Venue> allVenues = new ArrayList<>();
		String sqlSelectAllVenues = "SELECT * FROM venue";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllVenues);
		while(results.next()) {
			allVenues.add(mapRowToVenue(results));
		}
		
		return allVenues;
	}
	
	@Override
	public Venue getVenueById(Long venueId) {
		Venue venue = null;
		String sqlSelectProductById = "SELECT * FROM venue WHERE venue_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectProductById, venueId);
		if (results.next()) {
			venue = mapRowToVenue(results);
		}
		return venue;
	}
	
	private Venue mapRowToVenue(SqlRowSet row) {
		Venue venue = new Venue();
		venue.setId(row.getLong("venue_id"));
		venue.setName(row.getString("name"));
		venue.setDescription(row.getString("description"));
		venue.setCapacity(row.getInt("capacity"));
		venue.setImageName(row.getString("image"));
		return venue;
	}
	

}
