package com.doubleb.bmoto.security.service;

import com.doubleb.bmoto.entity.Authority;
import com.doubleb.bmoto.entity.User;
import com.doubleb.bmoto.repository.AuthorityRepository;
import com.doubleb.bmoto.repository.UserRepository;
import com.doubleb.bmoto.security.payload.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void save(SignupRequest signupRequest) {

        User user = new User();
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setEmail(signupRequest.getEmail());
        user.setCreatedAt(LocalDateTime.now());
        user.setDeletedFlag(false);
        user.setUsername(signupRequest.getUsername());
        user.setAuthorities(setCustomerAuthority());

        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        userRepository.save(user);
    }

    private Set<Authority> setCustomerAuthority() {
        Set<Authority> authorities = new HashSet<>();
        authorities.add(authorityRepository.findByAuthority("ROLE_CUSTOMER").orElseThrow(() -> new RuntimeException("Error: authority not found")));
        return authorities;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Username not found!"));
    }
}
