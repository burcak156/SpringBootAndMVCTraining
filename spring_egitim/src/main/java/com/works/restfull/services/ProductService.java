package com.works.restfull.services;

import com.works.restfull.entities.Product;
import com.works.restfull.repositories.ProductRepository;
import com.works.restfull.utils.REnum;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    final ProductRepository pRepo;
    final CacheManager cacheManager;

    public ProductService(ProductRepository pRepo, CacheManager cacheManager) {
        this.pRepo = pRepo;
        this.cacheManager = cacheManager;
    }

    public ResponseEntity save (Product product) {
        Map<REnum,Object> hm = new LinkedHashMap<>();
        hm.put(REnum.result,product);
        hm.put(REnum.status,true);
        pRepo.save(product);
        cacheManager.getCache("productList").clear();
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<REnum,Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status,true);
        hm.put(REnum.result, pRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(String stPid) {
        Map<REnum,Object> hm = new LinkedHashMap<>();

        try {
            int pid = Integer.parseInt(stPid);
            Optional<Product> oProduct = pRepo.findById(pid);
            if(oProduct.isPresent()) {
                Product product = oProduct.get();
                pRepo.deleteById(pid);
                hm.put(REnum.status, true);
                hm.put(REnum.result, product);
                return new ResponseEntity(hm, HttpStatus.OK);
            }
            else  {
                hm.put(REnum.status, false);
                hm.put(REnum.result, stPid);
                return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception exception) {
            hm.put(REnum.status, false);
            hm.put(REnum.result, stPid);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }


    }
    public ResponseEntity saveAll(List<Product> products) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        pRepo.saveAll(products);
        hm.put(REnum.status, true);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity listPage(int page) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        Pageable pg = PageRequest.of(page,10);
        Page<Product> products = pRepo.findAll(pg);
        hm.put(REnum.status, true);
        hm.put(REnum.result, products);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search (String q, int page) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        Pageable pg = PageRequest.of(page,10);
        hm.put(REnum.status, true);
        hm.put(REnum.result, pRepo.findByTitleContains(q, pg));
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
