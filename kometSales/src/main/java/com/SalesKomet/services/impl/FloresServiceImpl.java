package com.SalesKomet.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SalesKomet.models.entities.FloresEntity;
import com.SalesKomet.repository.FloresRepository;
import com.SalesKomet.services.FloresService;

@Service
public class FloresServiceImpl implements FloresService {
	private static List<FloresEntity> listaFlores = new ArrayList<FloresEntity>();

	@Autowired
	private FloresRepository floresRepository;

	@Override
	public FloresEntity saveFlower(FloresEntity floresEntity) {
		return floresRepository.save(floresEntity);
	}

	@Override
	public List<FloresEntity> showAllFlowers() {
		return (List<FloresEntity>) floresRepository.findAll();
	}

	@Override
	public FloresEntity updateFlower(Long id, FloresEntity floresEntity) {
		FloresEntity oldFlower = floresRepository.findById(id).get();
		oldFlower.setName(floresEntity.getName());
		oldFlower.setPrice(floresEntity.getPrice());
		return floresRepository.save(oldFlower);
	}

	@Override
	public boolean deleteFlower(Long id) {
		try {
			floresRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	@Override
	public List<FloresEntity> saveListOfFlowers(FloresEntity floresEntity) {
		FloresEntity f1 = new FloresEntity();
		f1.setName("Girasol");
		f1.setPrice(20.0);

		FloresEntity f2 = new FloresEntity();
		f2.setName("Orquídea");
		f2.setPrice(45.5);

		FloresEntity f3 = new FloresEntity();
		f3.setName("Clavel");
		f3.setPrice(65.2);

		FloresEntity f4 = new FloresEntity();
		f4.setName("Dalia");
		f4.setPrice(25.2);

		FloresEntity f5 = new FloresEntity();
		f5.setName("Cerezo");
		f5.setPrice(18.2);

		FloresEntity f6 = new FloresEntity();
		f6.setName("Peonias");
		f6.setPrice(10.99);

		listaFlores.add(f1);
		listaFlores.add(f2);
		listaFlores.add(f3);
		listaFlores.add(f4);
		listaFlores.add(f5);
		listaFlores.add(f6);

		return (List<FloresEntity>) floresRepository.saveAll(listaFlores);

	}

	@Override
	public List<FloresEntity> showByAlphabet(FloresEntity floresEntity) {

		listaFlores.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

		listaFlores.forEach((n) -> n.updateName());

		return 	listaFlores;
	}

	@Override
	public List<FloresEntity> showAllFlowersByPrice(FloresEntity floresEntity) {
		List<FloresEntity> flores = listaFlores.stream().filter(flor -> flor.getPrice() > 20).toList();
		return flores;
	}
		
	@Override
	public List<FloresEntity> showFlowersByName(FloresEntity floresEntity, String name) {
		List<FloresEntity> flores = listaFlores.stream().filter(flor -> flor.getName().equalsIgnoreCase(name)).toList();
		return flores;
	}

}
