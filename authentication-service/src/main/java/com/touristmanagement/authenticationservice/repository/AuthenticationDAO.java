package com.touristmanagement.authenticationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.touristmanagement.authenticationservice.models.Users;

@Repository
public interface AuthenticationDAO extends JpaRepository<Users, Long>{

	Optional<Users> findByEmailId(String username);

}
