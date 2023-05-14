package com.ltw.QLSach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltw.QLSach.model.Book;
import com.ltw.QLSach.model.BuyBook;
import com.ltw.QLSach.model.User;
import com.ltw.QLSach.service.BooksService;
import com.ltw.QLSach.service.BuyService;


@Controller
@RequestMapping("buy-book")
public class BuyController {
	@Autowired
	BooksService bookservice;
	@Autowired
	BuyService buyservice;
	
	@GetMapping("/view")
	public String ViewCart(Model model) {
		model.addAttribute("items", buyservice.getAllItems());
		model.addAttribute("TOTAL", buyservice.getAmount());
		return "buy";
	}
	
	@GetMapping("/add/{id}")
	public String addCart(@PathVariable int id) {
		Book book = bookservice.getBookById(id);
		System.out.println(book.getId());
		if(book !=null) {
			BuyBook item = new BuyBook();
			item.setId(book.getId());
			item.setTrangbia(book.getTrangbia());
			item.setTensach(book.getTensach());
			item.setGia(book.getGiasach());
			item.setQty(1);
			
			buyservice.addBuyBook(item);
			System.out.println(item.getTensach());
		}
		return "redirect:/buy-book/view";
	}
	
	@GetMapping("/clear")
	public String clearCart() {
		buyservice.clear();
		return "redirect:/buy-book/view";
	}
	
	@GetMapping("/del/{id}")
	public String removeCart(@PathVariable int id) {
		System.out.println("NO");
		buyservice.remove(id);
		return "redirect:/buy-book/view";
	}
	@PostMapping("/update")
	public String update(@RequestParam("id")int id, @RequestParam("qty")int qty) {
		buyservice.update(id, qty);
		return "redirect:/buy-book/view";
	}
	@PostMapping("/save")
	public String saveCart(@RequestParam("tenuser") String tenuser) {
		
		for(BuyBook i:buyservice.getAllItems()) {
			i.setTenuser(tenuser);
			buyservice.save(i);
		}
		return "redirect:/buy-book/view";
	}
	
}