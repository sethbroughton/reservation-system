package com.techelevator.model;

import java.util.List;

public interface RateDao {
	
	public List<Rate> listAllRates();
	
	public Rate getRateById();
	

}
