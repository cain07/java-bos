package com.cain.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cain.bos.dao.IRegionDao;
import com.cain.bos.domain.Region;
import com.cain.bos.service.IRegionService;

@Service
@Transactional
public class RegionService implements IRegionService{

	@Autowired
	private IRegionDao dao;
	
	@Override
	public void addBatch(List<Region> regions) {
		// TODO Auto-generated method stub
		for(Region region:regions){
			dao.save(region);
		}
	}

	
}
