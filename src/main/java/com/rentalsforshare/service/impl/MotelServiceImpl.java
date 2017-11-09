package com.rentalsforshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalsforshare.common.util.Constants;
import com.rentalsforshare.entity.Motel;
import com.rentalsforshare.repository.MotelRepository;
import com.rentalsforshare.service.MotelService;

@Service
public class MotelServiceImpl implements MotelService {

	@Autowired
	private MotelRepository motelRepository;

	@Override
	public Page<Motel> searchByPageAndKeyword(String keyword, int page) throws Exception {
		PageRequest request = new PageRequest(page - 1, Constants.PAGE_SIZE, Sort.Direction.ASC, "id");
		return motelRepository.searchByPageAndKeyword(keyword, request);
	}

	@Override
	public Motel getByCity(String city) throws Exception {
		return motelRepository.getByCity(city);
	}

	@Override
	public Motel getByWard(String ward) throws Exception {
		return motelRepository.getByCity(ward);
	}

	@Override
	public Motel getByStreet(String street) throws Exception {
		return motelRepository.getByCity(street);
	}

	@Override
	public Motel getByAddress(String address) throws Exception {
		return motelRepository.getByAddress(address);
	}

	@Override
	public Motel getById(Integer id) throws Exception {
		return motelRepository.getById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean insertMotel(Motel motel) throws Exception {
		return motelRepository.saveAndFlush(motel) != null ? true : false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateMotel(Motel motel) throws Exception {
		return motelRepository.save(motel) != null ? true : false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Integer id) throws Exception {
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
