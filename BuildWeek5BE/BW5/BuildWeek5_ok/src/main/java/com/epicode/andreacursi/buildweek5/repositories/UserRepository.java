package com.epicode.andreacursi.buildweek5.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.buildweek5.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   
	Optional<User> findByUsername(String n);
	 
	
}