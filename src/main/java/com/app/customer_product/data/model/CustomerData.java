package com.app.customer_product.data.model;

import com.app.customer_product.model.Customer;
import com.app.customer_product.model.Product;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record CustomerData(
        long id,
        String name,
        String surname,
        int age,
        BigDecimal cash,
        List<Long> products
) {
    public Customer toCustomer() {
        return Customer
                .builder()
                .id(id)
                .name(name)
                .surname(surname)
                .age(age)
                .cash(cash)
                .products(products)
                .build();
    }
}
