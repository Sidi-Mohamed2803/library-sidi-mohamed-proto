package com.library.library_sidi_mohamed.controller;

import java.util.Collection;

import com.library.library_sidi_mohamed.domain.Supplier;
import com.library.library_sidi_mohamed.domainManager.SupplierRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/supplier")
public class SupplierController {
	
	public static Supplier findById(int id)
	{
		return SupplierRepository.getById(id);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public static Collection<Supplier> findAll() {
		return SupplierRepository.getSuppliers();
	}
	
	public static void add(Supplier supplier) {
		SupplierRepository.save(supplier);
	}
	
	public static void remove(int id) {
		SupplierRepository.delete(id);
	}
}
