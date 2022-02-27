package com.zensar.olx.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olx.training.bean.AdvertismentStatus;
import com.zensar.olx.training.bean.Category;
import com.zensar.olx.training.db.AdvertisementStatusDAO;
import com.zensar.olx.training.db.CategoryDAO;
@Service
public class AdvertisementService {
	@Autowired
	 AdvertisementStatusDAO dao;
	
	public AdvertismentStatus addAdvertisementStatus( AdvertismentStatus advertisment) {
		return this.dao.save(advertisment);
	}
	
	public List< AdvertismentStatus> getAllAdvertisementStatus(){
		return this.dao.findAll();
	}
	public AdvertismentStatus findAdvertisementStatus(int id) {
		Optional<AdvertismentStatus> optional;
		optional = this.dao.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

}
