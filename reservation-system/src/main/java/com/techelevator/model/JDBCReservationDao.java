package com.techelevator.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCReservationDao implements ReservationDao {

	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCReservationDao (DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reservation> listAllReservations() {
		List<Reservation> allReservations = new ArrayList<>();
		String sqlSelectAllReservations = "SELECT * FROM reservations";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllReservations);
		while (results.next()) {
			allReservations.add(mapRowToReservation(results));
		}
		return allReservations;
	}

	@Override
	public Reservation getReservationById(Long reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Reservation mapRowToReservation(SqlRowSet row) {
		Reservation reservation = new Reservation();
		reservation.setReservationId(row.getLong("reservation_id"));
		reservation.setVenueId(row.getLong("venue_id"));
		reservation.setName(row.getString("name"));
		reservation.setRate_id(row.getLong("rate_id"));
		reservation.setDateStart(LocalDateTime.parse(row.getString("date_start")));
		reservation.setDateEnd(LocalDateTime.parse(row.getString("date_end")));
		reservation.setWeekend(row.getBoolean("weekend"));
		reservation.setWeekday(row.getBoolean("weekday"));
		reservation.setHoliday(row.getBoolean("holiday"));
		
		return reservation;
	}
	
	
}
