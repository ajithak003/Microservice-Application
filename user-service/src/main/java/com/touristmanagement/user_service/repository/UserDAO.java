package com.touristmanagement.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.touristmanagement.user_service.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{

}
