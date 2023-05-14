package com.ltw.QLSach.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltw.QLSach.model.BuyBook;
import com.ltw.QLSach.model.User;

@Repository
public interface BuyRepository extends JpaRepository<BuyBook, Integer> {
	BuyBook findByTenuser(String tenuser);
}
