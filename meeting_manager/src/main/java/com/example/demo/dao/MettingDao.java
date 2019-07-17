package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Matter;
import com.example.demo.entity.Meeting;

public interface MettingDao extends JpaRepository<Meeting, Integer>,JpaSpecificationExecutor<Matter> {

}
