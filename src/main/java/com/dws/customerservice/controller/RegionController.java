package com.dws.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dws.customerservice.dto.Region;
import com.dws.customerservice.service.RegionService;

@RestController
@RequestMapping("/region")
public class RegionController {

	@Autowired
	RegionService serviceRegion;
	
	@GetMapping
	public ResponseEntity<Object> getRegions(){
		return new ResponseEntity<>(serviceRegion.getRegions(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getRegion(@PathVariable("id") int id){
		return new ResponseEntity<>(serviceRegion.getRegion(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> createRegion(@RequestBody Region region){
		return new ResponseEntity<>(serviceRegion.createRegion(region), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateRegion(@PathVariable("id") int id, @RequestBody Region region){
		return new ResponseEntity<>(serviceRegion.updateRegion(region, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteRegion(@PathVariable("id") int id){
		return new ResponseEntity<>(serviceRegion.deleteRegion(id), HttpStatus.OK);
	}
}
