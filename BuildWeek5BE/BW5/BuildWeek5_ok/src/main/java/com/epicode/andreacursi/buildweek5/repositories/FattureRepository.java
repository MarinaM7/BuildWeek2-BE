package com.epicode.andreacursi.buildweek5.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.buildweek5.entity.Fatture;

@Repository
public interface FattureRepository extends JpaRepository<Fatture, Long>{

	@Query(nativeQuery = true,
            value = "SELECT * FROM be_service_fatture WHERE cliente_id = :id")
	List<Fatture> getFattureByClienteId(@Param("id")Long id);
	
	@Query(nativeQuery = true,
            value = "SELECT * FROM be_service_fatture WHERE stato_id = :stato")
	List<Fatture> getFattureByStato(@Param("stato")int stato);

	@Query(nativeQuery = true,
            value = "SELECT * FROM be_service_fatture WHERE anno = :anno")
	List<Fatture> getFattureByAnno(@Param("anno")int anno);
	
	@Query(nativeQuery = true,
            value = "SELECT * FROM be_service_fatture WHERE importo BETWEEN :from AND :to")
	List<Fatture> getFattureByImportRange(@Param("from")int from, @Param("to") int to);
	
}
