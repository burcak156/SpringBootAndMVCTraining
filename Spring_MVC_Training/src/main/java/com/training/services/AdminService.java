package com.training.services;

import com.training.entities.Admin;
import com.training.repositories.AdminRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class AdminService {

    final AdminRepository adminRepository;
    final HttpServletRequest req;

    public AdminService(AdminRepository adminRepository, HttpServletRequest req) {
        this.adminRepository = adminRepository;
        this.req = req;
    }

    public String login(Admin admin) {
         Optional<Admin> optional = adminRepository.findByEmailEqualsIgnoreCaseAndPasswordEquals(admin.getEmail(), admin.getPassword());
         if(optional.isPresent()) {
             Admin adm = optional.get();
             req.getSession().setAttribute("admin",adm);
            System.out.println("OK");
            return "redirect:/dashboard";
        }
        else {
            System.out.println("NOK");
            return "/login";
        }
    }
}
