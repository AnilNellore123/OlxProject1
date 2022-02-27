package com.zensar.olx.training.db;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.zensar.olx.training.bean.Category;
@Repository
public interface CategoryDAO extends JpaRepository<Category,Integer>{

}
