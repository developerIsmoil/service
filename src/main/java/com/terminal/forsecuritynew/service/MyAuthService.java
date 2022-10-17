package com.terminal.forsecuritynew.service;

import com.terminal.entity.Users;
import com.terminal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UsersRepository usersRepository;

    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username);
        if (users != null) {
            return users;
        }
        throw new UsernameNotFoundException("username yoki parol xato");
    }
}
