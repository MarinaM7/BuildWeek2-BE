package com.epicode.andreacursi.buildweek5.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.buildweek5.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
