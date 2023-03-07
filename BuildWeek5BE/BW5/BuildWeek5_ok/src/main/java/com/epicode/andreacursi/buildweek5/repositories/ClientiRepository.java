package com.epicode.andreacursi.buildweek5.repositories;

import java.security.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.buildweek5.entity.Clienti;

@Repository
public interface ClientiRepository extends JpaRepository<Clienti, Long>{

	// QUERIES PER L'ORDINAMENTO
    @Query(value = "SELECT * FROM be_service_clienti ORDER BY nome_contatto ASC",
            nativeQuery = true)
    Page<Clienti> ordinaPerNome(Pageable p);

    @Query(value = "SELECT * FROM be_service_clienti ORDER BY fatturato_annuale DESC",
            nativeQuery = true)
    Page<Clienti> ordinaPerFatturato(Pageable p);

    @Query(value = "SELECT * FROM be_service_clienti ORDER BY data_inserimento DESC",
            nativeQuery = true)
    Page<Clienti> ordinaPerDataInserimento(Pageable p);

    @Query(value = "SELECT * FROM be_service_clienti ORDER BY data_ultimo_contatto DESC",
            nativeQuery = true)
    Page<Clienti> ordinaPerDataUltimoContatto(Pageable p);

    @Query(value = "SELECT * FROM be_service_clienti ORDER BY indirizzo_sede_legale_id ASC",
            nativeQuery = true)
    Page<Clienti> ordinaPerProvinciaSede(Pageable p);
    
    //QUERY FILTRAGGIO 
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM be_service_clienti WHERE fatturato_annuale = :valore"
        )
        List<Clienti> findByFatturatoAnnuale(@Param("valore") double valore);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM be_service_clienti WHERE data_inserimento LIKE CONCAT('%',:valore,'%')"
        )
        List<Clienti> findByDataInserimento(@Param("valore") Timestamp valore);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM be_service_clienti WHERE data_ultimo_contatto = :valore"
        )
        List<Clienti> findByDataUltimoContatto(@Param("valore") Timestamp valore);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM be_service_clienti WHERE nome_contatto LIKE CONCAT('%',:valore,'%')"
        )
        List<Clienti> findByNomeParziale(@Param("valore") String valore);
	
}
