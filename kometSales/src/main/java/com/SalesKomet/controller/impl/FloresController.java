package com.SalesKomet.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.SalesKomet.models.entities.FloresEntity;
import com.SalesKomet.repository.FloresRepository;
import com.SalesKomet.services.FloresService;

@RestController 
public class FloresController {
	
	@Autowired
	private FloresService floresService;
	
	@PostMapping("/save-one") 
	public ResponseEntity<?> saveFlower(@RequestBody FloresEntity floresEntity ){
		FloresEntity newFloresEntity;			
		try {
			 newFloresEntity = floresService.saveFlower(floresEntity);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);   
		}
		return new ResponseEntity<FloresEntity>(newFloresEntity, HttpStatus.CREATED); 
	}	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<FloresEntity> updateFlower(@RequestBody FloresEntity floresEntity, @PathVariable Long id){
		FloresEntity newFloresEntity = null;	
		try {			
			newFloresEntity = floresService.updateFlower(id, floresEntity);
		} catch(Exception e) { 
			return new ResponseEntity<>(newFloresEntity, HttpStatus.NOT_FOUND);
		}			
		return new ResponseEntity<FloresEntity>(newFloresEntity, HttpStatus.OK);
	}

	@GetMapping("/show-all")
	public ResponseEntity<List<FloresEntity>> showFlowers() {
		List<FloresEntity> flores = floresService.showAllFlowers();
		return new ResponseEntity<List<FloresEntity>>(flores, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFlower(@PathVariable Long id){			
		boolean entity = this.floresService.deleteFlower(id);		
		try {
			entity = floresService.deleteFlower(id);			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); 		
		}				
		return new ResponseEntity<>(entity, HttpStatus.OK);  
	}
	
	@PostMapping("/save-many")
	public ResponseEntity<?> saveListOfFlowers(FloresEntity floresEntity){
		List<FloresEntity> flowers;
		try {
			flowers = floresService.saveListOfFlowers(floresEntity);		 
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); 
		}					
		return new ResponseEntity<List<FloresEntity>>(flowers, HttpStatus.OK);
	}	
	
	@GetMapping("/show-alphabet")
	public ResponseEntity<List<FloresEntity>> showByAlphabet(FloresEntity floresEntity) {
		List<FloresEntity> flores = null; 
		try {		
		flores = floresService.showByAlphabet(floresEntity); 
		}catch(Exception e){
			return new ResponseEntity<>(flores, HttpStatus.BAD_REQUEST); 
		}
		return new ResponseEntity<List<FloresEntity>>(flores, HttpStatus.OK);
	}
	
	@GetMapping("/show-price")
	public ResponseEntity<List<FloresEntity>> showAllFlowersByPrice(FloresEntity floresEntity) {
		List<FloresEntity> flores = null; 
		try {		
		flores = floresService.showAllFlowersByPrice(floresEntity); 
		}catch(Exception e){
			return new ResponseEntity<>(flores, HttpStatus.BAD_REQUEST); 
		}
		return new ResponseEntity<List<FloresEntity>>(flores, HttpStatus.OK);
	}
	
	@GetMapping("/show-name/{name}")
	public ResponseEntity<List<FloresEntity>> showFlowersByName(FloresEntity floresEntity, @PathVariable String name) {
		List<FloresEntity> flores = null; 
		try {		
		flores = floresService.showFlowersByName(floresEntity, name); 
		}catch(Exception e){
			return new ResponseEntity<>(flores, HttpStatus.BAD_REQUEST); 
		}
		return new ResponseEntity<List<FloresEntity>>(flores, HttpStatus.OK);
	}
	
	
}
