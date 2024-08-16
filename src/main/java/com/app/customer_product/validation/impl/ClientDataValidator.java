package com.app.customer_product.validation.impl;

import com.app.customer_product.data.model.CustomerData;
import com.app.customer_product.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@AllArgsConstructor
public class ClientDataValidator implements Validator<CustomerData> {

    private String regex;

    @Override
    public Map<String, String> validate(CustomerData customerData) {
        Map<String, String> errors = new HashMap<>();


        if (doesNotMatchRegex(customerData.name(), regex)) {
            errors.put("name", "does not match regex: " + customerData.name());
        }

        if (doesNotMatchRegex(customerData.surname(), regex)) {
            errors.put("surname", "does not match regex: " + customerData.surname());
        }

        if (customerData.age() < 18) {
            errors.put("age", "must be higher than 18: " + customerData.age());
        }

        if (customerData.cash().compareTo(BigDecimal.ZERO) <= 0) {
            errors.put("cash", "must be positive: " + customerData.cash());
        }

        return errors;
    }

    private static boolean doesNotMatchRegex(String text, String regex) {
        return text == null || !text.matches(regex);
    }
}
