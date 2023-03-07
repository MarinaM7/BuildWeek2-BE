package com.epicode.andreacursi.buildweek5.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.buildweek5.entity.Fatture;
import com.epicode.andreacursi.buildweek5.services.FattureService;

@RestController
@RequestMapping("/fatture")
public class FattureController {
	
	@Autowired
	FattureService fs;

	@GetMapping("/")
	public Page<Fatture> getAllFatture() {
		Pageable paging = (Pageable) PageRequest.of(0, 10);
		return fs.getAll_page(paging);
	}
	
	@GetMapping("/cliente={id}")
	public List<Fatture> getByClienteId(@PathVariable Long id){
		return fs.getFattureByClienteId(id);
	}
	
	@GetMapping("/anno={anno}")
	public List<Fatture> getByAnno(@PathVariable int anno){
		return fs.getFattureByAnno(anno);
	}
	
	@GetMapping("/range={from}-{to}")
	public List<Fatture> getByImportRange(@PathVariable int from, @PathVariable int to){
		return fs.getFattureByImportRange(from, to);
	}
	
	@GetMapping("/stato={text}")
    public List<Fatture> getByStatoId(@PathVariable String text){
        int id = 0;

        switch(text) {
        case "pagato":
            id = 1;
            break;
        case "nonPagato":
            id = 2;
        }

        return fs.getFattureByStato(id);
    }
	
}
