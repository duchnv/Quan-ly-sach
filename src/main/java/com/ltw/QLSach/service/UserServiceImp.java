package com.ltw.QLSach.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltw.QLSach.model.User;
import com.ltw.QLSach.repository.UserRepository;

@Service
public class UserServiceImp implements UserSerivce {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        // TODO Auto-generated method stub
        this.userRepository.save(user);
    }

    
    @Override
    public Optional<User> findById(String id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id);
    }


    @Override
    public boolean checkLogin(String username, String password) {
        // TODO Auto-generated method stub
        Optional<User> optional = findById(username);
        if (optional.isPresent() && optional.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }


	@Override
	public User findUserByid(String username) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    
    

}
