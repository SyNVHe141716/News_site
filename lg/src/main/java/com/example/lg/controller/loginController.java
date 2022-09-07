package com.example.lg.controller;

import com.example.lg.model.User;
import com.example.lg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @Autowired
    UserService responsitory;

    @GetMapping("/login")
    public String a(Model model, @ModelAttribute("user") User user){

        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("user")User user, Model model, HttpSession session){
        System.out.println(user.getName());
        User check= responsitory.findUser(user.getName(),user.getPassword());
        if(check!=null){
            session.setAttribute("acc",check);
            return "redirect:/home";
        }else{
            model.addAttribute("mess","User and password incorrect");
            return "login";
        }
    }
}
