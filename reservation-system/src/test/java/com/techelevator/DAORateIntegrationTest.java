package com.techelevator;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.model.JDBCRateDao;
import com.techelevator.model.Rate;

public class DAORateIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	private JDBCRateDao rateDao;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/reservation");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sqlDeleteRate = "DELETE FROM rate";
		jdbcTemplate.update(sqlDeleteRate);
		String sqlInsertNewRate = 
				"INSERT INTO rate (name, venue_id, description, rate_dollar, includes_cleaning_fee, starting_month, ending_month, weekend, weekday, holiday) " +
				"VALUES ('Weekday',1,'Monday-Friday before 4:30', 350.00, false, 'January', 'December', false, true, false)";
		jdbcTemplate.update(sqlInsertNewRate);
		rateDao = new JDBCRateDao(dataSource);
	}
	

	@Test
	public void listAllRates() throws SQLException {
		List<Rate> allRates = rateDao.listAllRates();
		Assert.assertEquals(allRates.get(0).getName(), "Weekday");
		Assert.assertNotNull(allRates);
		Assert.assertEquals(allRates.size(), 1);
	}

}
