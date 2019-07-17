package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MatterDao;
import com.example.demo.entity.Matter;
import com.example.demo.service.MatterService;

@Service(value = "MatterServiceImpl")
public class MatterServiceImpl implements MatterService {
	@Autowired
	MatterDao MatterDao;

	@Override
	public void save(Matter entity) {
		MatterDao.save(entity);
	}

	@Override
	public List<Matter> findBydeptnoId(String deptnoId) {
		return MatterDao.findByDeptnoId(deptnoId);
	}
}
