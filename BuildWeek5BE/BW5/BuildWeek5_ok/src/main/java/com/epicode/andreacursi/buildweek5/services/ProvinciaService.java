package com.epicode.andreacursi.buildweek5.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.buildweek5.entity.Provincia;
import com.epicode.andreacursi.buildweek5.repositories.ProvinciaRepository;

@Service
public class ProvinciaService {

	@Autowired
	private ProvinciaRepository proRepo;
	
	public Provincia inserisci(Provincia p) {
		return proRepo.save(p);
	}
	
	public Optional<Provincia> ottieniDaId(int id){
		return proRepo.findById(id);
	}
	
	public List<Provincia> ottieniTutti(){
		return proRepo.findAll();
	}
	
	public List<Provincia> ottieniDaNome(String nome){
		return proRepo.findByNome(nome);
	}
}
