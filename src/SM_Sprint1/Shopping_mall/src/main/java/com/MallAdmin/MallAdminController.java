package com.MallAdmin;

import java.util.List; 
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")//angular
@RequestMapping("mall_admin")
public class MallAdminController {
	@Autowired
	private MallAdminService service;

	// Retrieve all Admins
	@GetMapping  
	public List<MallAdmin> listAll() {
		return service.listAll();
	}

	// Retrieve Admin by ID
	@GetMapping("/{id}")
	public ResponseEntity<MallAdmin> get(@PathVariable Integer id) {
		try {
			MallAdmin mallAdmin = service.get(id);
			return new ResponseEntity<>(mallAdmin, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Create Admin
	@PostMapping
	public ResponseEntity<MallAdmin> add(@RequestBody MallAdmin mallAdmin) {
		service.save(mallAdmin);
		return new ResponseEntity<>(mallAdmin, HttpStatus.CREATED); // Changed from NOT_FOUND to CREATED
	}

	// Update Admin
	@PutMapping("/{id}")
	public ResponseEntity<MallAdmin> update(@RequestBody MallAdmin mallAdmin, @PathVariable Integer id) {
	    try {
	        System.out.println("Attempting to update MallAdmin with ID: " + id);
	        MallAdmin existingMallAdmin = service.get(id);
	        
	
			 
	        existingMallAdmin.setUsername(mallAdmin.getUsername());
	        existingMallAdmin.setPassword(mallAdmin.getPassword());
	        existingMallAdmin.setEmail(mallAdmin.getEmail());
	        existingMallAdmin.setLoginAttempts(mallAdmin.getLoginAttempts());
	        existingMallAdmin.setIsActive(mallAdmin.getIsActive());
	        existingMallAdmin.setLastLoginTime(mallAdmin.getLastLoginTime());

	        service.save(existingMallAdmin);
	        return new ResponseEntity<>(existingMallAdmin, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	// Delete Admin
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		try {
			service.delete(id);
			return ResponseEntity.ok().build();
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
