package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Rate;
import com.techelevator.model.RateDao;
import com.techelevator.model.Venue;
import com.techelevator.model.VenueDao;

/**
 * SiteController
 */

@Controller
public class SiteController {

	@Autowired
	private VenueDao venueDao;
	private RateDao rateDao;
	

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String displayHomePage(ModelMap modelHolder) {

		// List all current reservations
		// Find available dates
		// Create new reservation
		List<Venue> venues = venueDao.listOfVenues();
		modelHolder.put("venues", venues);

		return "home";
	}

	@RequestMapping(path = "/venueDetail", method = RequestMethod.GET)
	public String showVenueDetail(@RequestParam Long id, ModelMap modelHolder) {

		List<Rate> allRates = rateDao.listAllRates();
		modelHolder.put("rates", allRates);

		return "venue";
		
		
	}
	
	

}
