package com.app.customer_product.repository.impl;

import com.app.customer_product.converter.client.impl.JsonFileToProductsConverterImpl;
import com.app.customer_product.model.Product;
import com.app.customer_product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products;

    public ProductRepositoryImpl(JsonFileToProductsConverterImpl jsonFileToProductsConverter, String filename) {
        products = jsonFileToProductsConverter.convert(filename);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
