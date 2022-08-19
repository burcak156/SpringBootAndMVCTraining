package com.works.restfull.services;

import com.works.restfull.entities.Customer;
import com.works.restfull.repositories.CustomerRepository;
import com.works.restfull.utils.REnum;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CustomerService {

    final CustomerRepository cRepo;

    public CustomerService(CustomerRepository cRepo) {
        this.cRepo = cRepo;
    }

    public ResponseEntity save(Customer customer) {
        Map<REnum, Object> hm = new LinkedHashMap<>();

        try {
            cRepo.save(customer);
            hm.put(REnum.status, true);
            hm.put(REnum.result, customer);
            return new ResponseEntity(hm, HttpStatus.OK);
        } catch (Exception ex) {
            hm.put(REnum.status, false);
            hm.put(REnum.result, ex.getMessage());
            return new ResponseEntity(hm, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity list() {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        hm.put(REnum.result, cRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}