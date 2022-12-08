package com.example.springbootwithreactcrudoperations.repository;

import com.example.springbootwithreactcrudoperations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
