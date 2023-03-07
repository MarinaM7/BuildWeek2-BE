package com.epicode.andreacursi.buildweek5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.buildweek5.entity.Comune;

@Repository
public interface ComuneRepository extends JpaRepository<Comune, Integer>{

}
