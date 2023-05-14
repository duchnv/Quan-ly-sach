package com.ltw.QLSach.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ltw.*;
import com.ltw.QLSach.model.Book;
import com.ltw.QLSach.service.BooksService;

@Controller

public class BooksController {
    
    @Autowired
    private BooksService booksService;
    
    @GetMapping("/books")
    public String getBooks(Model model, HttpSession session) throws IOException {
    	List<Book> books = booksService.getAllBooks();
		model.addAttribute("listBooks", books);
		return "index";
        
    }
    
    
    @GetMapping("/books/new/{id}")
    public String getNewBook(@PathVariable(value = "id") int id, ModelMap model) {
        if(id>0) {
        	Book book = booksService.getBookById(id);
        	List<String> options = new ArrayList<String>();
        	options.add("Khoa học");
    		options.add("Văn học");
            options.add("Chính trị");
            options.add("Truyện");
            options.add("Tâm lý");
            model.addAttribute("options", options);
            model.addAttribute("book", book);
            
        }else {
        	Book book = new Book();
        	List<String> options = new ArrayList<String>();
        	options.add("Khoa học");
    		options.add("Văn học");
            options.add("Chính trị");
            options.add("Truyện");
            options.add("Tâm lý");
            model.addAttribute("options", options);
            model.addAttribute("book", book);
        }
        return "new";
    }
    
    @GetMapping("/books/comment/{id}")
    public String getCmtBook(@PathVariable(value = "id") int id, ModelMap model) {
    	List<Book> books = booksService.getAllBooks();
    	model.addAttribute("listBooks", books);
    	if(id>0) {
    		Book book = booksService.getBookById(id);
        	List<String> options = new ArrayList<String>();
        	options.add("Khoa học");
    		options.add("Văn học");
            options.add("Chính trị");
            options.add("Truyện");
            options.add("Tâm lý");
            model.addAttribute("options", options);
            model.addAttribute("book", book);
    	}
        return "comment";
    }
    
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") int id, ModelMap model) {
        booksService.deleteBookById(id);
        model.addAttribute("message", "Account is deleted!");
        return "redirect:/books" ;
    }
    
    
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/uploads";
    @PostMapping("/books/save/{id}")
    public String saveBooks(@Valid @ModelAttribute("book") Book book,Model model, BindingResult bindingResult, @PathVariable(value = "id") int id,  @RequestParam("image") MultipartFile file) throws IOException
    {
    	if (bindingResult.hasErrors())
	    {	
    		List<String> options = new ArrayList<String>();
    		options.add("Khoa học");
    		options.add("Văn học");
            options.add("Chính trị");
            options.add("Truyện");
            options.add("Tâm lý");
            model.addAttribute("options", options);
	        return "new";
	    }
    	
		StringBuilder fileNames = new StringBuilder();  
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        book.setTrangbia(fileNames.toString());
        System.out.println(fileNames.toString());
        if(!fileNames.toString().isEmpty()) {
        	Files.write(fileNameAndPath, file.getBytes());
        }
        booksService.saveBooks(book);
        return "redirect:/books";
      
    }
    
}
