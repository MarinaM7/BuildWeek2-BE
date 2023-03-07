package com.epicode.andreacursi.buildweek5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.andreacursi.buildweek5.configuration.Beans;
import com.epicode.andreacursi.buildweek5.configuration.LetturaDaCsv;
import com.epicode.andreacursi.buildweek5.entity.Comune;
import com.epicode.andreacursi.buildweek5.entity.Provincia;
import com.epicode.andreacursi.buildweek5.entity.Role;
import com.epicode.andreacursi.buildweek5.entity.RoleType;
import com.epicode.andreacursi.buildweek5.entity.User;
import com.epicode.andreacursi.buildweek5.services.ComuneService;
import com.epicode.andreacursi.buildweek5.services.ProvinciaService;
import com.epicode.andreacursi.buildweek5.services.RoleService;
import com.epicode.andreacursi.buildweek5.services.UserService;

@SpringBootApplication

public class BuildWeek5Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BuildWeek5Application.class, args);
	}
	
	@Autowired
	ProvinciaService proSe;
	
	@Autowired
	ComuneService comSe;

	@Autowired
	RoleService roleS;
	
	@Autowired
	UserService userS;
	
	@Override
	public void run(String... args) throws Exception {
		
//		inserisciDaCSV();
//		insertRoles();
//		insertUsers();
		
	}
	
	public void inserisciDaCSV() {
		
		//INSERIMENTO PROVINCE NEL DB
		List<Provincia> province = 
				LetturaDaCsv.leggiProvinceDaCSV("C:\\Users\\Utente\\Desktop\\DatiDelDB\\province-italiane.csv");
		
		// let's print all the person read from CSV file 
		for (Provincia p : province) { 
			proSe.inserisci(p);
		}
		
		//INSERIMENTO COMUNI NEL DB
		List<Comune> comuni = 
				LetturaDaCsv.leggiComuniDaCSV("C:\\Users\\Utente\\Desktop\\DatiDelDB\\comuni-italiani2.csv");
		
		// let's print all the person read from CSV file 
		for (Comune c : comuni) { 
			comSe.inserisci(c);
		}

	}
	
	public void insertRoles() {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		
		Role r1 = (Role)ctx.getBean("role", RoleType.ROLE_USER);
		Role r2 = (Role)ctx.getBean("role", RoleType.ROLE_ADMIN);
		
		roleS.addRole(r1);
		roleS.addRole(r2);

		 ((AnnotationConfigApplicationContext)ctx).close();
	}
	
	public void insertUsers() {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		
		Role rUser = roleS.getById(1).get();
		Role rAdmin = roleS.getById(2).get();
		
		Set<Role> setUser = new HashSet<>() {{
			add(rUser);
		}};
		
		Set<Role> setAdmin = new HashSet<>() {{
			add(rAdmin);
		}};
				
		User u1 = (User)ctx.getBean("user", "mario", "Mario", "Rossi", true, "mario", "mario@gmail.it", setAdmin);
		
		userS.addUser(u1);

		((AnnotationConfigApplicationContext)ctx).close();
	}
	
}
