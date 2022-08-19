package com.works.restfull.repositories;

import com.works.restfull.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findByTitleContains(String title, Pageable pageable);

    List<Product> findByDetailLikeIgnoreCase(String detail);


}