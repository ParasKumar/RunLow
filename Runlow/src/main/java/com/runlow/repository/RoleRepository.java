package com.runlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.runlow.model.Role;

@Repository("roleRepository") 
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findById(int roleId);

}
