package com.app.customer_product.validation.impl;

import com.app.customer_product.data.model.ProductData;
import com.app.customer_product.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@AllArgsConstructor
public class ProductDataValidator implements Validator<ProductData> {

    private String regex;

    @Override
    public Map<String, String> validate(ProductData productData) {
        Map<String, String> errors = new HashMap<>();


        if (doesNotMatchRegex(productData.name(), regex)) {
            errors.put("name", "does not match regex: " + productData.name());
        }

        if (doesNotMatchRegex(productData.category(), regex)) {
            errors.put("category", "does not match regex: " + productData.category());
        }

        if (productData.price().compareTo(BigDecimal.ZERO) <= 0) {
            errors.put("price", "must be positive: " + productData.price());
        }

        return errors;
    }

    private static boolean doesNotMatchRegex(String text, String regex) {
        return text == null || !text.matches(regex);
    }
}
