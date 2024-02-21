package com.asius.bookshop.Services.implement;

import com.asius.bookshop.Entity.UsersEntity;
import com.asius.bookshop.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServicesImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity userload = usersRepository.findByUsername(username);
        if (userload ==null){
            throw new UsernameNotFoundException ("User not found");
        }
        return userload;
    }


}
