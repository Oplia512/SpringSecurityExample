package com.example.demo.service;


import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with " + username + " was not found!"));
    }

    public List<User> findAll() {
        return userDao.findAll().orElse(Collections.emptyList());
    }

    public Optional<User> findById(@NonNull ObjectId id){
        return userDao.findById(id);
    }
}
