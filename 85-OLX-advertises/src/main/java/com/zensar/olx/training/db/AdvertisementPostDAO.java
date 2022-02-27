package com.zensar.olx.training.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.olx.training.bean.AdvertisementPost;
@Repository
public interface AdvertisementPostDAO extends JpaRepository<AdvertisementPost, Integer>{
	

}
