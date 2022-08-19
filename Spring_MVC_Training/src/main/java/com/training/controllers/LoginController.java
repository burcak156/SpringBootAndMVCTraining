package com.training.controllers;

import com.training.entities.Admin;
import com.training.services.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    final AdminService adminService;

    public LoginController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("name","Burçak Yılmaz");
        return "login";
    }
    @PostMapping("/login")
    public String adminLogin(Admin admin) {

        System.out.println(admin);
        //model.addAttribute("name","Burçak Yılmaz");
        return adminService.login(admin);
    }
}
