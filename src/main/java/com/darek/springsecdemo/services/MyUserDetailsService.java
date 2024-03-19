package com.darek.springsecdemo.services;

import com.darek.springsecdemo.dao.UserRepo;
import com.darek.springsecdemo.model.User;
import com.darek.springsecdemo.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user ==null){
            throw new RuntimeException("user Not Found");
        }
        return new UserPrincipal(user);
    }
}
