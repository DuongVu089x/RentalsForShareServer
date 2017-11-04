package com.rentalsforshare.service;


import org.springframework.data.domain.Page;

import com.rentalsforshare.entity.Motel;

public interface MotelService {
	
	Page<Motel> searchByPageAndKeyword(String keyword, int page) throws Exception;
	
	Motel getByCity(String city) throws Exception;
	Motel getByWard(String ward) throws Exception;
	Motel getByStreet(String street) throws Exception;
	
	Motel getById(Integer id) throws Exception;
	
	boolean insertMotel(Motel motel) throws Exception;
	
	boolean updateMotel(Motel motel) throws Exception;
	
	boolean delete(Integer id) throws Exception;
	
	
}
