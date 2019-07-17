package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Boradroom;

public interface BoradroomDao extends JpaRepository<Boradroom, Integer>,JpaSpecificationExecutor<Boradroom> {
	
}
