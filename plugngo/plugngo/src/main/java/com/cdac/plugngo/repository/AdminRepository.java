package com.cdac.plugngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.plugngo.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
