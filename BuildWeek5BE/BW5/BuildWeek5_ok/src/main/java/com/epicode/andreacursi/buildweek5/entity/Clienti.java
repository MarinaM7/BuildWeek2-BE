package com.epicode.andreacursi.buildweek5.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name="be_service_clienti")
public class Clienti {

	@Id
    private long id;
    private String nomeContatto;
    private String cognomeContatto;
    private String ragioneSociale;
    private String partitaIva;
    private String email;
    private String emailContatto;
    private String pec;
    private BigDecimal fatturatoAnnuale;
    private Timestamp dataInserimento;
    private Timestamp dataUltimoContatto;
    private String telefono;
    private String telefonoContatto;
    private String tipoCliente;
    private long indirizzoSedeLegaleId;
    private long indirizzoSedeOperativaId;
	
}
