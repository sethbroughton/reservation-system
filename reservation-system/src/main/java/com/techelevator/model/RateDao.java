package com.techelevator.model;

import java.util.List;

public interface RateDao {
	
	public List<Rate> listAllRates(Long id);
	
	public Rate getRateById();
	

}
