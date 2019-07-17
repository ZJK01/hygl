package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Department;


public interface DepartmentDao extends JpaRepository<Department, Integer>,JpaSpecificationExecutor<Department> {

}
