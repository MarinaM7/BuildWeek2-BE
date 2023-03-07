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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name="be_service_fatture")
public class Fatture {

	@Id
	private long id;
	private int anno;
	private Timestamp data;
	private BigDecimal importo;
	private int numero;
	private long clienteId;
	private long statoId;
	
}
