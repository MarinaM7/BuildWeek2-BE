package com.epicode.andreacursi.buildweek5.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.buildweek5.entity.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM provincia WHERE provincia = :valore"
		)
		List<Provincia> findByNome(@Param("valore") String valore);
	
}
