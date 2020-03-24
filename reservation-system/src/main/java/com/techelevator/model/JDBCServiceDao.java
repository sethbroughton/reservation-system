package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCServiceDao implements ServiceDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCServiceDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public void saveService(Service service) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Service> listAllServices() {
		
		List<Service> allServices = new ArrayList<>();
		String sqlSelectAllServices = "SELECT * from service";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllServices);
		while (results.next()) {
			allServices.add(mapRowToService(results));
		}
		return allServices;
	}

	@Override
	public Service getServicebyId(Long serviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Service mapRowToService(SqlRowSet row) {
		Service service = new Service();
		service.setServiceId(row.getLong("service_id"));
		service.setName(row.getString("name"));
		service.setDescription(row.getString("description"));
		service.setPrice(row.getBigDecimal("rate_dollar"));
		return service;
	}

}
