package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Rate {
	
	private Long rateId;
	private Long venueId;
	private String name;
	private String description;
	private BigDecimal rateDollar;
	private boolean cleaningFee;
	private String startingMonth;
	private String endingMonth;
	private boolean weekend;
	private boolean weekday;
	private boolean holiday;
	
	
	public Long getRateId() {
		return rateId;
	}
	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getRateDollar() {
		return rateDollar;
	}
	public void setRateDollar(BigDecimal rateDollar) {
		this.rateDollar = rateDollar;
	}
	public boolean isCleaningFee() {
		return cleaningFee;
	}
	public void setCleaningFee(boolean cleaningFee) {
		this.cleaningFee = cleaningFee;
	}
	public String getStartingMonth() {
		return startingMonth;
	}
	public void setStartingMonth(String startingMonth) {
		this.startingMonth = startingMonth;
	}
	public String getEndingMonth() {
		return endingMonth;
	}
	public void setEndingMonth(String endingMonth) {
		this.endingMonth = endingMonth;
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
	public Long getVenueId() {
		return venueId;
	}
	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}


}
