package com.example.demo.service;


import com.example.demo.dao.UserDao;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @PostConstruct
    private void init(){
//        userDao.findByUsername("power").ifPresent(user -> {
//            user.setPassword(new BCryptPasswordEncoder().encode("pass"));
//            userDao.save(user);
//        });
//
//        userDao.findByUsername("admin").ifPresent(user -> {
//            user.setPassword(new BCryptPasswordEncoder().encode("pass"));
//            userDao.save(user);
//        });

//        if (!userDao.findByUsername("user").isPresent()){
//            userDao.save(User.builder()
//                    .username("user")
//                    .password("pass")
//                    .authorities(ImmutableList.of(Role.USER))
//                    .isAccountNonExpired(true)
//                    .isCredentialsNonExpired(true)
//                    .isAccountNonLocked(true)
//                    .isEnabled(true)
//                    .build());
//        }
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with " + username + " was not found!"));
    }

    public List<User> finfAll(){
        return userDao.findAll();
    }
}
