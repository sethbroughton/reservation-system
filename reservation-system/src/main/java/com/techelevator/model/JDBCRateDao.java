package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCRateDao implements RateDao{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCRateDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Rate> listAllRates() {
		List<Rate> allRates = new ArrayList<>();
		String sqlSelectAllRates = "SELECT * FROM rate";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllRates);
		while(results.next()) {
			allRates.add(mapRowToRate(results));
		}
		return allRates;
	}

	@Override
	public Rate getRateById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Rate mapRowToRate(SqlRowSet row) {
		Rate rate = new Rate();
		rate.setRateId(row.getLong("rate_id"));
		rate.setVenueId(row.getLong("venue_id"));
		rate.setName(row.getString("name"));
		rate.setDescription(row.getString("description"));
		rate.setRateDollar(row.getBigDecimal("rate_dollar"));
		rate.setCleaningFee(row.getBoolean("includes_cleaning_fee"));
		rate.setStartingMonth(row.getString("starting_month"));
		rate.setEndingMonth(row.getString("ending_month"));
		rate.setWeekend(row.getBoolean("weekend"));
		rate.setWeekday(row.getBoolean("weekday"));
		rate.setHoliday(row.getBoolean("holiday"));

		return rate;
	}

}
