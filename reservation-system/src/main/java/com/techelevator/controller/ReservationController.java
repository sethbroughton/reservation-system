package com.techelevator.controller;

import java.time.LocalDateTime;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.authentication.UnauthorizedException;
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
public class ReservationController {

	@Autowired
	private VenueDao venueDao;
	
	@Autowired
	private RateDao rateDao;
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Autowired
	private ReservationDao reservationDao;
	
    @Autowired
    private AuthProvider auth;
	
	public static final String APPLICATION_KEY = "reservation";

    @RequestMapping(path = "/private", method = RequestMethod.GET)
    public String privatePage() throws UnauthorizedException {
        if (auth.userHasRole(new String[] { "admin", "user" })) {
            return "private";
        } else {
            throw new UnauthorizedException();
        }
    }
	
	
	@RequestMapping(path = {"/"}, method = RequestMethod.GET)
	public String privatePage(ModelMap modelHolder) {

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

		return "redirect:/reservation";
	}
	
	@RequestMapping(path="reservation", method = RequestMethod.GET)
	public String showReservationInput(HttpSession session) {
		
		if(session.getAttribute("reservation") == null) {
			return "redirect:/home";
		}
		else {
			return "reservation";
		}
	}
	
	@RequestMapping(path="reservation", method = RequestMethod.POST)
	public String handleReservationInput(
			@RequestParam LocalDateTime startDate, LocalDateTime endDate, 
			HttpSession session) {
		
		Reservation reservation = (Reservation) session.getAttribute("reservation");
		
		if(reservation == null) {
			return "redirect:/home";
		}
		
		reservation.setClient_id(1L);
		reservation.setDateStart(startDate);
		reservation.setDateEnd(endDate);
		reservationDao.saveReservation(reservation);
		session.setAttribute("reservation", reservation);
		
		return "redirect:/summary";
	}
	
	
	@RequestMapping(path="summary", method = RequestMethod.GET)
	public String showSummaryPage(HttpSession session) {
		
		if(session.getAttribute("reservation") == null) {
			return "redirect:/home";
		}
		else {
			return "summary";
		}
	}
	
	

}
