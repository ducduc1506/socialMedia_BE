package com.example.socialMediaBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialMediaBE.entity.User;

public interface AuthRepository extends JpaRepository<User, Long> {
   
}
