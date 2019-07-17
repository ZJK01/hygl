package com.example.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MettingDao;
import com.example.demo.entity.Meeting;
import com.example.demo.service.MeetingService;

@Service(value="MeetingServiceImpl")
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	MettingDao mettingDao;
	
	@Override
	public Integer count() {
		return (int) mettingDao.count();
	}

	@Override
	public Page<Meeting> fy(Integer pages, Integer pageCount) {
		Pageable pageable = new PageRequest(pages, pageCount);
		Page<Meeting> page = mettingDao.findAll(pageable);
		return page;
	}

	@Override
	public void add(Meeting meeting) {
		mettingDao.save(meeting);
	}
	

	
}	
