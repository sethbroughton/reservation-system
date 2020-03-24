package com.techelevator.model;

import java.time.LocalDateTime;

public class Reservation {
	
    private Long reservationId;
    private Long venueId;
    private String name;
    private Long rate_id;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;

    private boolean weekend;
    private boolean weekday;
    private boolean holiday;
    
	public Long getReservationId() {
		return reservationId;
	}
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	public Long getVenueId() {
		return venueId;
	}
	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRate_id() {
		return rate_id;
	}
	public void setRate_id(Long rate_id) {
		this.rate_id = rate_id;
	}
	public LocalDateTime getDateStart() {
		return dateStart;
	}
	public void setDateStart(LocalDateTime dateStart) {
		this.dateStart = dateStart;
	}
	public LocalDateTime getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(LocalDateTime dateEnd) {
		this.dateEnd = dateEnd;
	}

	public boolean isWeekend() {
		return weekend;
	}
	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}
	public boolean isWeekday() {
		return weekday;
	}
	public void setWeekday(boolean weekday) {
		this.weekday = weekday;
	}
	public boolean isHoliday() {
		return holiday;
	}
	public void setHoliday(boolean holiday) {
		this.holiday = holiday;
	}
}
