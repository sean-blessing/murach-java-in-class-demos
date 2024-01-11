package com.murach.web;

import com.murach.db.ProductRepo;
import com.murach.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/")
    public Iterable<Product> getAll() {
        return productRepo.findAll();
    }
    @GetMapping("/{code}")
    public Optional<Product> get(@PathVariable String code) {
        return productRepo.findById(code);
    }

    @PostMapping("/")
    public Product add(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PutMapping("/")
    public Product update(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @DeleteMapping("/{code}")
    public Optional<Product> delete(@PathVariable String code){
        Optional<Product> product = productRepo.findById(code);
        if (product.isPresent()) {
            productRepo.deleteById(code);
        }
        return product;
    }
}
