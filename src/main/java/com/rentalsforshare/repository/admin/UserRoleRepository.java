package com.rentalsforshare.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentalsforshare.entity.admin.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{

//	User getByEmail(String email);
}
