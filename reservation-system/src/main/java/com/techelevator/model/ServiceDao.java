package com.techelevator.model;

import java.util.List;

public interface ServiceDao {
	
	public void saveService(Service service);
	
	public List<Service> listAllServices();

	public Service getServicebyId(Long serviceId);
	

}
