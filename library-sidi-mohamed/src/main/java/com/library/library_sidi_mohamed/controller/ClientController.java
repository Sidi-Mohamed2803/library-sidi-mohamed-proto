package com.library.library_sidi_mohamed.controller;

import java.time.LocalDate;
import java.util.Collection;

import com.library.library_sidi_mohamed.domain.Client;
import com.library.library_sidi_mohamed.domainManager.ClientRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/client")
public class ClientController {
	
	
	public static void add(Client client)
	{
		ClientRepository.save(client);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public static Collection<Client> findAll() {
		return ClientRepository.getClients();
	}
	
	
	public static Client findById(int id) {	
		return ClientRepository.getById(id);
	}
	
	public static void update(int id, String fname, String lname, LocalDate dob) {
		ClientRepository.edit(id, fname, lname, dob);
	}
	
	public static void remove(int id) {
		ClientRepository.delete(id);
	}
}
