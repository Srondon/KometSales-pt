package com.SalesKomet.repository;

import org.springframework.data.repository.CrudRepository;
import com.SalesKomet.models.entities.FloresEntity;

public interface FloresRepository extends CrudRepository<FloresEntity, Long> {
	//-> CrudRepository para implementar el CRUD de la Base de Datos.
}
