package com.rentalsforshare.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rentalsforshare.entity.Motel;

@Repository
public interface MotelRepository extends JpaRepository<Motel, Integer> {

	@Query(value = "SELECT m FROM Motel m WHERE m.address LIKE %:keyword% OR m.city LIKE %:keyword% OR m.ward LIKE %:keyword%  OR m.street LIKE %:keyword%")
	Page<Motel> searchByPageAndKeyword(@Param("keyword") String keyword, Pageable request) throws Exception;

	Motel getByCity(String city) throws Exception;

	Motel getByWard(String ward) throws Exception;

	Motel getByStreet(String street) throws Exception;

	Motel getById(Integer id) throws Exception;

	Motel getByAddress(String address) throws Exception;

}
