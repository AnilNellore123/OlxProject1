package com.zensar.olx.training.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.olx.training.bean.AdvertismentStatus;

@Repository
public interface AdvertisementStatusDAO extends JpaRepository<AdvertismentStatus, Integer>{

}
