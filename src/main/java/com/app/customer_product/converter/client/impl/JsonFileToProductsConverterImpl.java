package com.app.customer_product.converter.client.impl;

import com.app.customer_product.converter.client.FileToProductsConverter;
import com.app.customer_product.data.json.deserializer.JsonDeserializer;
import com.app.customer_product.data.model.ProductData;
import com.app.customer_product.data.model.ProductsData;
import com.app.customer_product.model.Product;
import com.app.customer_product.validation.Validator;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class JsonFileToProductsConverterImpl implements FileToProductsConverter {

    private final JsonDeserializer<ProductsData> productsDataJsonDeserializer;
    private final Validator<ProductData> productDataValidator;

    @Override
    public List<Product> convert(String filename) {
        return productsDataJsonDeserializer
                .deserialize(filename)
                .products()
                .stream()
                .filter(clientData -> Validator.validate(clientData, productDataValidator))
                .map(ProductData::toProduct)
                .toList();    }
}
