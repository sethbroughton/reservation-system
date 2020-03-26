package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Reservation;
import com.techelevator.model.Service;

@Controller
public class ShoppingController {
	
	/*
	 * 	@RequestMapping(path="reservation", method = RequestMethod.GET)
	public String showReservationInput(ModelMap modelHolder) {
		
		List<Service> allServices = serviceDao.listAllServices();
		modelHolder.put("services", allServices);
		
		return "services";
	}
	
	@RequestMapping(path="service", method = RequestMethod.POST)
	public String handleServiceSelection(
			@RequestParam String service,
			HttpSession session) {
		
		Reservation reservation = (Reservation) session.getAttribute("reservation");
		
		if(reservation == null) {
			return "redirect:/home";
		}
		
	 * 
	 * 
	 */

}
