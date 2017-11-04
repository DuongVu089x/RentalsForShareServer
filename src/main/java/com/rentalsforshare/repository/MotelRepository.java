package com.rentalsforshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.rentalsforshare.entity.Motel;

@Repository
public interface MotelRepository extends JpaRepository<Motel, Integer>  {
	
	Motel getByCity(String city);
	Motel getByWard(String ward);
	Motel getByStreet(String street);
	Motel getById(Integer id);
	

}
