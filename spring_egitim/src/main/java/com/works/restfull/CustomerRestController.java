package com.works.restfull;

import com.works.restfull.entities.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class CustomerRestController {


    @GetMapping("/data")
    public Map data(@RequestParam String name) {
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        hm.put("name",name);
        hm.put("age",28);
        return hm;
    }


    @PostMapping("/create")
    public Map create(@RequestBody Customer cust) {
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        hm.put("customer",cust);
        return hm;
    }
}
