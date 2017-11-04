package com.rentalsforshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rentalsforshare.entity.Motel;
import com.rentalsforshare.repository.MotelRepository;
import com.rentalsforshare.service.MotelService;

@Service
public class MotelServiceImpl implements MotelService {

	@Autowired
	private MotelRepository motelRepository;
	
	@Override
	public Motel getByCity(String city)
	{
		return motelRepository.getByCity(city);
	}
	
	@Override
	public Motel getByWard(String ward)
	{
		return motelRepository.getByCity(ward);
	}
	
	@Override
	public Motel getByStreet(String street)
	{
		return motelRepository.getByCity(street);
	}
	@Override
	public Motel getById(Integer id)
	{
		return motelRepository.getById(id);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean insertMotel(Motel motel) throws Exception
	{
		return motelRepository.saveAndFlush(motel) != null ? true : false;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateMotel(Motel motel) throws Exception
	{
		return motelRepository.save(motel) != null ? true : false;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Integer id) throws Exception
	{
		boolean result = false;
		try {
			motelRepository.delete(id);
			result = true;
		} catch (Exception e) {
			throw (e);
		}
		return result;
		
	}
}
