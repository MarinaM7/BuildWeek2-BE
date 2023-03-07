package com.epicode.andreacursi.buildweek5.configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epicode.andreacursi.buildweek5.entity.Comune;
import com.epicode.andreacursi.buildweek5.entity.Provincia;
import com.epicode.andreacursi.buildweek5.services.ProvinciaService;

public class LetturaDaCsv {
	
	@Autowired
	static ProvinciaService proSe;
	
	//LETTURA PROVINCE

	public static List<Provincia> leggiProvinceDaCSV(String fileName) {
		List<Provincia> province = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		
		// create an instance of BufferedReader 
		// using try with resource, Java 7 feature to close resources 
		try (BufferedReader br = Files.newBufferedReader(pathToFile, 
				StandardCharsets.UTF_8)) { 
			
			// read the first line from the text file 
			String line = br.readLine();
			System.out.println(line);
			// loop until all lines are read
			while (line != null) {
				
				// use string.split to load a string array with the values from 
				// each line of 
				// the file, using a comma as the delimiter
				if(line.equals("﻿Sigla;Provincia;Regione")) {
					System.out.println("Linea di inizio province");
				}else {
					String[] attributi = line.split(";");
					Provincia provincia = creaProvincia(attributi);
					// adding book into ArrayList 
					province.add(provincia); 
					// read next line before looping 
					// if end of file reached, line would be null 
				}
				line = br.readLine();
				} 
			} catch (IOException ioe) { 
				ioe.printStackTrace(); 
				}
		return province; 
				}
	
	public static Provincia creaProvincia(String[] metadata) { 
		String sigla = metadata[0]; 
		String provincia = metadata[1]; 
		String regione = metadata[2]; 
		Provincia p= Provincia.builder().sigla(sigla).provincia(provincia).regione(regione).build();
		
		return p; 
		}
	
	//LETTURA COMUNI
	
	public static List<Comune> leggiComuniDaCSV(String fileName) {
		List<Comune> comuni = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		
		// create an instance of BufferedReader 
		// using try with resource, Java 7 feature to close resources 
		try (BufferedReader br = Files.newBufferedReader(pathToFile, 
				StandardCharsets.UTF_8)) { 
			
			// read the first line from the text file 
			String line = br.readLine();
			System.out.println(line);
			// loop until all lines are read
			while (line != null) {
				
				// use string.split to load a string array with the values from 
				// each line of 
				// the file, using a comma as the delimiter
				if(line.equals("Codice Provincia (Storico)(1);Progressivo del Comune (2);"
						+ "Denominazione in italiano;Provincia")) {
					System.out.println("Linea di inizio comuni");
				}else {
					String[] attributi = line.split(";");
					Comune comune= creaComune(attributi);
					// adding book into ArrayList 
					comuni.add(comune); 
					// read next line before looping 
					// if end of file reached, line would be null 	
				}
				line = br.readLine();
				} 
			} catch (IOException ioe) { 
				ioe.printStackTrace(); 
				}
		return comuni; 
				}
	
	public static Comune creaComune(String[] metadata) { 
		String nome = metadata[2]; 
		String provincia = metadata[3];
		Comune c= Comune.builder().nome(nome).provincia(provincia).build();
		
		return c; 
		}
}
