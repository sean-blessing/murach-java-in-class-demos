package com.murach.db;

import com.murach.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, String> {
}
