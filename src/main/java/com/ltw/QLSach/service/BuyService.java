package com.ltw.QLSach.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.ltw.QLSach.model.Book;
import com.ltw.QLSach.model.BuyBook;
import com.ltw.QLSach.repository.BuyRepository;
@SessionScope
@Service
public class BuyService {
	Map<Integer, BuyBook> maps = new HashMap<>();
	@Autowired
	private BuyRepository buyRepository;
	
	public void addBuyBook(BuyBook item) {
		BuyBook buyBook = maps.get(item.getId());
		if(buyBook == null) {
			maps.put(item.getId(), item);
		}else {
			buyBook.setQty(buyBook.getQty()+1);
		}
	}
	
	public void remove(int id) {
		maps.remove(id);
	}
	
	public BuyBook update(int id, int qty) {
		BuyBook buyBook = maps.get(id);
		buyBook.setQty(qty);
//		buyBook.setGia(qty*buyBook.getBook().getGiasach());
		return buyBook;
	}
	
	public void clear() {
		maps.clear();
	}
	
	public Collection<BuyBook> getAllItems(){
		return maps.values();
	}
	
	public int getCount() {
		return maps.values().size();
	}
	
	public double getAmount() {
		return maps.values().stream().mapToDouble(item -> item.getQty()*item.getGia()).sum();
	}

	public BuyBook save(BuyBook buybook) {
		return buyRepository.save(buybook);
	}
	
	public List<BuyBook> findbyTenuser(String tenuser) {
		return  (List<BuyBook>) buyRepository.findByTenuser(tenuser);
	}
}
