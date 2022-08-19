package com.works.restfull.restcontroller;

import com.works.restfull.entities.Customer;
import com.works.restfull.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/customer")
public class CustomerUseRestController
{
    final CustomerService cService;

    public CustomerUseRestController(CustomerService cService) {
        this.cService = cService;
    }

    @PostMapping("/save")
    public ResponseEntity save (@RequestBody Customer customer) {
        return cService.save(customer);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return cService.list();
    }
}
