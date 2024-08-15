package com.app.customer_product.repository.impl;

import com.app.customer_product.converter.client.impl.JsonFileToCustomersConverterImpl;
import com.app.customer_product.model.Customer;
import com.app.customer_product.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
    private List<Customer> customers;

    public CustomerRepositoryImpl(JsonFileToCustomersConverterImpl jsonFileToClientsConverter, String filename) {
        customers = jsonFileToClientsConverter.convert(filename);
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public Customer getById(Long id) {
        return customers
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException(String.format("Customer with id %d not found", id)));
    }
}
