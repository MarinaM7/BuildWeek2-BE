package com.epicode.andreacursi.buildweek5.controllers;

import java.security.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.buildweek5.entity.Clienti;
import com.epicode.andreacursi.buildweek5.services.ClientiService;

@RestController
@RequestMapping("/clienti")
public class ClientiController {

	@Autowired
	ClientiService cs;

	//ORDERED
	
	@GetMapping("/nome/")
	public Page<Clienti> getClientiPerNome_page(@RequestParam Integer pageSize, @RequestParam Integer pageNo) {
		Pageable paging = (Pageable) PageRequest.of(pageNo, pageSize);
		return cs.orderByNome(paging);
	}
	
	@GetMapping("/fatturato/")
	public Page<Clienti> getClientiPerFatturato_page(@RequestParam Integer pageSize, @RequestParam Integer pageNo) {
		Pageable paging = (Pageable) PageRequest.of(pageNo, pageSize);
		return cs.orderByFatturato(paging);
	}
	
	@GetMapping("/inserimento/")
	public Page<Clienti> getClientiPerDataInserimento_page(@RequestParam Integer pageSize, @RequestParam Integer pageNo) {
		Pageable paging = (Pageable) PageRequest.of(pageNo, pageSize);
		return cs.orderByDataInserimento(paging);
	}
	
	@GetMapping("/ultimocontatto/")
	public Page<Clienti> getClientiPerDataUltimoContatto_page(@RequestParam Integer pageSize, @RequestParam Integer pageNo) {
		Pageable paging = (Pageable) PageRequest.of(pageNo, pageSize);
		return cs.orderByDataUltimoContatto(paging);
	}
	
	@GetMapping("/provinciasede/")
	public Page<Clienti> getClientiPerProvinciaSede_page(@RequestParam Integer pageSize, @RequestParam Integer pageNo) {
		Pageable paging = (Pageable) PageRequest.of(pageNo, pageSize);
		return cs.orderByProvinciaSede(paging);
	}
	
	//FILTERED
	
	@GetMapping("/fatturatoannuale={fatt}")
	public List<Clienti> getClientiPerFatturatoAnnuale(@PathVariable double fatt) {
		return cs.ottieniDaFatturatoAnnuale(fatt);
	}
	
	@GetMapping("/datainserimento={data}")
	public List<Clienti> getClientiPerDataInserim(@PathVariable Timestamp data) {
		return cs.ottieniDaDataInserimento(data);
	}
	
	@GetMapping("/dataultimocontatto={data}")
	public List<Clienti> getClientiPerDataUltimoContatto(@PathVariable Timestamp data) {
		return cs.ottieniDaDataUltimoContatto(data);
	}
	
	@GetMapping("/nome={nome}")
	public List<Clienti> getClientiPerNomeParziale(@PathVariable String nome) {
		return cs.ottieniDaNomeParziale(nome);
	}
}
