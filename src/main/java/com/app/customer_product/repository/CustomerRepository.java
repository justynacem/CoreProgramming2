package com.app.customer_product.repository;

import com.app.customer_product.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAll();
    Customer getById(Long id);
}
