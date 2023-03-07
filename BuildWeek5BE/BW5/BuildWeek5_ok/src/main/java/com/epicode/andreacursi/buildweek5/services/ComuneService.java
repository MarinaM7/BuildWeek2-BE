package com.epicode.andreacursi.buildweek5.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.buildweek5.entity.Comune;
import com.epicode.andreacursi.buildweek5.repositories.ComuneRepository;

@Service
public class ComuneService {

	@Autowired
	private ComuneRepository comRepo;
	
	public Comune inserisci(Comune c) {
		return comRepo.save(c);
	}
	
	public Optional<Comune> ottieniDaId(int id){
		return comRepo.findById(id);
	}
	
	public List<Comune> ottieniTutti(){
		return comRepo.findAll();
	}
	
}
