package com.doubleb.bmoto.security.service;

import com.doubleb.bmoto.entity.User;
import com.doubleb.bmoto.security.payload.request.SignupRequest;

public interface UserService {

    void save(SignupRequest signupRequest);
    User findByUsername(String username);
}
