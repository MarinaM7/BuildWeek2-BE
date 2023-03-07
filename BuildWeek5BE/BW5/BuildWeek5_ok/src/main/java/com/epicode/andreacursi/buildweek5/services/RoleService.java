package com.epicode.andreacursi.buildweek5.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.buildweek5.entity.Role;
import com.epicode.andreacursi.buildweek5.repositories.RoleRepository;


@Service
public class RoleService {
	
	@Autowired
	RoleRepository repo;
	
	public void addRole(Role r) {
		repo.save(r);
	}
	
	public Optional<Role> getById(int id) {
		return repo.findById(id);
	}
	
}
