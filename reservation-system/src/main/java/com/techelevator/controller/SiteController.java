package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Rate;
import com.techelevator.model.RateDao;
import com.techelevator.model.Reservation;
import com.techelevator.model.ReservationDao;
import com.techelevator.model.Service;
import com.techelevator.model.ServiceDao;
import com.techelevator.model.Venue;
import com.techelevator.model.VenueDao;

/**
 * SiteController
 */

@Controller
public class SiteController {

	@Autowired
	private VenueDao venueDao;
	
	@Autowired
	private RateDao rateDao;
	
	@Autowired
	private ServiceDao serviceDao;
	
	public static final String APPLICATION_KEY = "reservation";

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
	public String showVenueDetail(@RequestParam Long id, 
			ModelMap modelHolder, 
			HttpSession session) {
		Reservation reservation = (Reservation) session.getAttribute("reservation");

		if (reservation == null) {
			reservation = new Reservation();
		}
		reservation.setVenueId(id);
		session.setAttribute("reservation", reservation);
		
		List<Rate> allRates = rateDao.listAllRates();
		modelHolder.put("rates", allRates);
		
		return "venue";
		
	}
	
	@RequestMapping(path = "/venueDetail", method = RequestMethod.POST)
	public String handleRateSelection(@RequestParam Long id, ModelMap modelHolder, 
			HttpSession session) {
		Reservation reservation = (Reservation) session.getAttribute("reservation");
		
		if(reservation == null) {
			return "redirect:/home";
		}
		

		return "redirect:/services";
		
	}
	
	@RequestMapping(path="services", method = RequestMethod.GET)
	public String showServicesDetail(ModelMap modelHolder) {
		
		List<Service> allServices = serviceDao.listAllServices();
		modelHolder.put("services", allServices);
		
		return "services";
	}
	
//	@RequestMapping(path="service", method = RequestMethod.POST)
//	public String handleServiceSelection(HttpSession session) {
//		
//		
//	}

}
