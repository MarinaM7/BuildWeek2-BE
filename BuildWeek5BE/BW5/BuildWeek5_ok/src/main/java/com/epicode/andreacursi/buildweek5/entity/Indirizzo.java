package com.epicode.andreacursi.buildweek5.entity;

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
@Table(name="be_service_indirizzi")
public class Indirizzo {

	@Id
	private long id;
	private String cap;
	private String civico;
	private String localita;
	private String via;
	private long comuneId;
	
}
