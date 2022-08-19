package com.training.controllers;

import com.training.services.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardController {

    final HttpServletRequest req;
    final DashboardService dashboardService;

    public DashboardController(HttpServletRequest req, DashboardService dashboardService) {
        this.req = req;
        this.dashboardService = dashboardService;
    }



    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        boolean status = req.getSession().getAttribute("admin") == null;
        if (status) {
            return "redirect:/";
        }

        else{
            model.addAttribute("productList",dashboardService.allProduct());
            model.addAttribute("xml",dashboardService.xml());
            return "dashboard";
        }
    }
}
