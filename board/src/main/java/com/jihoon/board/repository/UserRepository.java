package com.jihoon.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jihoon.board.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    
}
