package com.SalesKomet.services;

import java.util.List;
import com.SalesKomet.models.entities.FloresEntity;

public interface FloresService {


	FloresEntity saveFlower(FloresEntity floresEntity);
	
	List<FloresEntity> showAllFlowers();
	
	FloresEntity updateFlower(Long id, FloresEntity floresEntity);
	
	boolean deleteFlower(Long id);
	

	List<FloresEntity> saveListOfFlowers(FloresEntity floresEntity);
		
	List<FloresEntity> showByAlphabet(FloresEntity floresEntity);
	
	List<FloresEntity> showAllFlowersByPrice(FloresEntity floresEntity);
	
	List<FloresEntity> showFlowersByName(FloresEntity floresEntity, String name);
	
}
