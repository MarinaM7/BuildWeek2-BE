package com.epicode.andreacursi.buildweek5.configuration;

import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.epicode.andreacursi.buildweek5.entity.Provincia;
import com.epicode.andreacursi.buildweek5.entity.Role;
import com.epicode.andreacursi.buildweek5.entity.RoleType;
import com.epicode.andreacursi.buildweek5.entity.User;

@Configuration
public class Beans {

	@Bean
	@Scope("prototype")
	public Role role(RoleType r) {
		return Role.builder().roleType(r).build();
	}
	
	@Bean
	@Scope("prototype")
	public User user(String username, String firstname, String lastname, boolean active, String passw, String email, Set<Role> roles ) {
		return User.builder().username(username).firstName(firstname).lastName(lastname).active(active).password(passw).email(email).roles(roles).build();
	}
}
