package com.rentalsforshare.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentalsforshare.entity.admin.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer>{

	Action getByName(String name);
}
