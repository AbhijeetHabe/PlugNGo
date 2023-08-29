package com.cdac.plugngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.plugngo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
