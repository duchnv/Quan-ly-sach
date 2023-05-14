package com.ltw.QLSach.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltw.QLSach.model.User;
import com.ltw.QLSach.service.BooksService;
import com.ltw.QLSach.service.UserSerivce;

@Controller
public class UsersController {

    @Autowired
    private UserSerivce userSerivce;
    
    @Autowired
    private BooksService booksService;
    
    @GetMapping("/sign-up")
    public String signUp(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registrator";
    }
    
    @GetMapping("/login")
    public String logIn(Model model) {
        return "login";
    }
    
    @GetMapping("/log-out")
    public String logOut(Model model, HttpSession session) {
        session.removeAttribute("username");
        model.addAttribute("listBooks", booksService.getAllBooks());
        return "index";
    }
    
    @PostMapping("/save-user")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult)
    {
    	User username = userSerivce.findUserByid(user.getUsername());
        if(bindingResult.hasErrors() || username != null)
        {
            return "registrator";
        }
        userSerivce.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/check-login")
    public String checkLogin(@RequestParam("username")String username,@RequestParam("password") String password ,Model  model, HttpSession session) {
       if(userSerivce.checkLogin(username, password))
       {
           session.setAttribute("username", username);
           model.addAttribute("listBooks", booksService.getAllBooks());
           return "index";
       }
       else
       {
           model.addAttribute("error", "Tài khoản hoặc mật khẩu đã sai!!!");
       }
        return "login";

    }
    
    
    
    
    
    

}
