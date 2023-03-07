package com.epicode.andreacursi.buildweek5.services;

import java.security.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.buildweek5.entity.Clienti;
import com.epicode.andreacursi.buildweek5.repositories.ClientiRepository;

@Service
public class ClientiService {
	
    @Autowired
    private ClientiRepository cR;
    
    //ORDINAMENTO
    public Page<Clienti> orderByNome(Pageable p){
        return cR.ordinaPerNome(p);
    }
    public Page<Clienti> orderByFatturato(Pageable p){
        return cR.ordinaPerFatturato(p);
    }
    public Page<Clienti> orderByDataInserimento(Pageable p){
        return cR.ordinaPerDataInserimento(p);
    }
    public Page<Clienti> orderByDataUltimoContatto(Pageable p){
        return cR.ordinaPerDataUltimoContatto(p);
    }
    public Page<Clienti> orderByProvinciaSede(Pageable p){
        return cR.ordinaPerProvinciaSede(p);
    }

    //FILTRAGGIO
    public List<Clienti> ottieniDaFatturatoAnnuale(double fatturato){
        return cR.findByFatturatoAnnuale(fatturato);
    }

    public List<Clienti> ottieniDaDataInserimento(Timestamp data){
        return cR.findByDataInserimento(data);
    }

    public List<Clienti> ottieniDaDataUltimoContatto(Timestamp data){
        return cR.findByDataUltimoContatto(data);
    }

    public List<Clienti> ottieniDaNomeParziale(String nomeParziale){
        return cR.findByNomeParziale(nomeParziale);
    }
    
}