package com.zensar.olx.training.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.olx.training.bean.LoginUser;
import com.zensar.olx.training.bean.OlxUser;
@Repository
public interface OlxUserDAO extends JpaRepository<OlxUser,Integer>{
OlxUser findByUserName(String userName);
}
