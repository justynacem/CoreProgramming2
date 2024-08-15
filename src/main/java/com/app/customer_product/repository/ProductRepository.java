package com.app.customer_product.repository;
import com.app.customer_product.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();
}
