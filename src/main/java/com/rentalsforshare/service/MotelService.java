package com.rentalsforshare.service;


import com.rentalsforshare.entity.Motel;

public interface MotelService {
	Motel getByCity(String city);
	Motel getByWard(String ward);
	Motel getByStreet(String street);
	
	Motel getById(Integer id);
	
	boolean insertMotel(Motel motel) throws Exception;
	
	boolean updateMotel(Motel motel) throws Exception;
	
	boolean delete(Integer id) throws Exception;
	
	
}
