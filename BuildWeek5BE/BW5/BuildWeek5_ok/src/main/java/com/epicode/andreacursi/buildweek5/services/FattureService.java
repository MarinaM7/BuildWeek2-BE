package com.epicode.andreacursi.buildweek5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.buildweek5.entity.Fatture;
import com.epicode.andreacursi.buildweek5.repositories.FattureRepository;

@Service
public class FattureService {
	
	@Autowired
	FattureRepository fr;
	
	public List<Fatture> getFattureByClienteId(Long id){
		return fr.getFattureByClienteId(id);
	}
	
	public List<Fatture> getFattureByStato(int stato){
		return fr.getFattureByStato(stato);
	}
	
	public List<Fatture> getFattureByAnno(int anno){
		return fr.getFattureByAnno(anno);
	}

	public List<Fatture> getFattureByImportRange(int from, int to){
		return fr.getFattureByImportRange(from, to);
	}

	public Page<Fatture> getAll_page(Pageable paging) {
		// TODO Auto-generated method stub
		return fr.findAll(paging);
	}
}
