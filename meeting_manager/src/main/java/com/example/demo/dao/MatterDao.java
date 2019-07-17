package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Matter;

public interface MatterDao extends JpaRepository<Matter, Integer>, JpaSpecificationExecutor<Matter> {

	public List<Matter> findByDeptnoId(String deptnoId);
}
