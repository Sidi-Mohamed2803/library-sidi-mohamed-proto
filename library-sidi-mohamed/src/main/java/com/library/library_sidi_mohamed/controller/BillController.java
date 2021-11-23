package com.library.library_sidi_mohamed.controller;

import com.library.library_sidi_mohamed.domain.Bill;
import com.library.library_sidi_mohamed.domainManager.BillRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/bill")
public class BillController {
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public static void add(Bill bill) {
		BillRepository.save(bill);
	}
}
