package com.rentalsforshare.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentalsforshare.entity.admin.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User getByEmail(String email);
}
