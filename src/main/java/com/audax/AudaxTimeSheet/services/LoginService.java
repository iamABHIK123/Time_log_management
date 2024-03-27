package com.audax.AudaxTimeSheet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audax.AudaxTimeSheet.repositories.LoginRepo;

@Service
public class LoginService {
	@Autowired
    private LoginRepo loginRepo;
    public String validateUser(String userid, String password) {
//   
//    	if(loginRepo.existsByUsername(username)) return "error";
//    	
//    	if(loginRepo.findUserTypeByUsername(username).equals("admin")) {
//    		 return "admin";
//    	}
//    	
//    	else if(loginRepo.findUserTypeByUsername(username).equals("user")) {
//    		 return "user";
//    	}
//    	
//    	else {
//    		 return "error";
//    	}
    	
    	
        switch (userid) {
            case "admin":
                if ("password".equals(password)) {
                    return "admin";
                }
                break;
            case "user":
                if ("password".equals(password)) {
                    return "user";
                }
                break;
        }
        return "error";
    }
}
    	
    
