package com.example.spring_security.repository;

import com.example.spring_security.entity.AppRole;
import com.example.spring_security.entity.AppUser;
import com.example.spring_security.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole>findByAppUser(AppUser appUser);
}
