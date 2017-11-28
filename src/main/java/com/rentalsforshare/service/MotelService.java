package com.rentalsforshare.service;

import org.springframework.data.domain.Page;

import com.rentalsforshare.entity.Motel;

public interface MotelService {

	Page<Motel> searchByPageAndKeyword(String keyword, int page) throws Exception;
	
	Integer getTotalPage(String keyword) throws Exception;
	
	Motel getByCity(String city) throws Exception;

	Motel getByWard(String ward) throws Exception;

	Motel getByStreet(String street) throws Exception;

	Motel getById(Integer id) throws Exception;

	Motel getByAddress(String address) throws Exception;

	boolean insertMotel(Motel motel) throws Exception;

	boolean updateMotel(Motel motel) throws Exception;

	boolean delete(Integer id) throws Exception;

	

}
