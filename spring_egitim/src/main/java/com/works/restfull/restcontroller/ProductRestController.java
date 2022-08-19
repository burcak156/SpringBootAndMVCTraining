package com.works.restfull.restcontroller;

import com.works.restfull.entities.Product;
import com.works.restfull.services.ProductService;
import com.works.restfull.utils.REnum;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    final ProductService productService;


    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/list")
    @Cacheable("productList")
    public ResponseEntity list() {
        return productService.list();
    }

    @DeleteMapping("/delete/{stPid}")
    public ResponseEntity delete(@NotNull @NotEmpty @PathVariable String stPid) {
        return productService.delete(stPid);
    }

    @PostMapping("/saveAll")
    public ResponseEntity saveAll(@RequestBody List<Product> products) {
        return productService.saveAll(products);
    }

    @GetMapping("/listPage")
    public ResponseEntity listPage (@RequestParam(defaultValue = "0") int page) {

        return productService.listPage(page);
    }

    @GetMapping("/search")
    public ResponseEntity search (@RequestParam String q, @RequestParam(defaultValue = "0") int page) {

        return productService.search(q, page);
    }
}
