package com.zensar.olx.training.sevice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olx.training.bean.OlxUser;
import com.zensar.olx.training.db.OlxUserDAO;

@Service
public class OlxUserService {
	 @Autowired
	    OlxUserDAO dao;
	     
	        

	    public OlxUser addOlxUser(OlxUser olxUser) {
	    	return this.dao.save(olxUser);
	    }
	    
	    public OlxUser updateOLXUser(OlxUser olxUser) {
	        return this.dao.save(olxUser);

	}
	    public OlxUser findOLXUser(int id) {
	        Optional<OlxUser>optional=this.dao.findById(id);
	    if(optional.isPresent())
	        return optional.get();
	    else
	        return null;
	}
	    public OlxUser findOlxUserByName(String name) {
	    	OlxUser olxUser=this.dao.findByUserName(name);
	    	System.out.println("Olxuser"+dao);
	    		return olxUser;
	    	}
	    }


