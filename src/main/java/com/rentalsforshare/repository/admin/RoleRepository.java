package com.rentalsforshare.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentalsforshare.entity.admin.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role getByName(String name);
}
