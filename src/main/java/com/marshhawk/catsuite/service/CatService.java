package com.marshhawk.catsuite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marshhawk.catsuite.model.Cat;
import com.marshhawk.catsuite.repos.CatRepository;

@Service
public class CatService implements UserDetailsService {
  @Autowired
  private CatRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    { 
      Cat currentCat = repository.findByCatName(username);
        UserDetails user = new org.springframework.security.core
            .userdetails.User(username, currentCat.getPassword()
            , true, true, true, true, 
            AuthorityUtils.createAuthorityList(currentCat.getRole()));
        return user;
    }
}