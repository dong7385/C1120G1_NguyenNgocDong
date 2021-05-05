package com.example.user_validation.service;

import com.example.user_validation.model.User;

import java.util.List;

public interface UserService {
List<User>findAll();
void save(User user);
}
