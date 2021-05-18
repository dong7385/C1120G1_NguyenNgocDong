package com.test_module_4.service.blog.impl;

import com.test_module_4.model.blog.User;
import com.test_module_4.repository.blog.UserRepository;
import com.test_module_4.service.blog.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
