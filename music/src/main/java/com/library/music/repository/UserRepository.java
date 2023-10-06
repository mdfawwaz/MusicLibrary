package com.library.music.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.music.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

		 public  Optional<User> findByName(String name);
		 
		 public boolean existsByName(String name);

		

}

