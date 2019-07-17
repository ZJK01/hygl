package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Postition;

public interface PositionDao extends JpaRepository<Postition,Integer>,JpaSpecificationExecutor<Postition>{

}
