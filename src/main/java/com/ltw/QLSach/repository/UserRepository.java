package com.ltw.QLSach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltw.QLSach.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
