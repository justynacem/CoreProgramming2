package com.app.customer_product;

import com.app.customer_product.data.model.CustomerData;

import java.math.BigDecimal;
import java.util.List;

public interface Customers {
    CustomerData JANE_DOE_DATA = CustomerData.builder()
            .id(1)
            .name("Jane")
            .surname("Doe")
            .age(18)
            .cash(BigDecimal.valueOf(2000))
            .products(List.of(1L, 2L))
            .build();

    CustomerData JOHN_DOE_DATA = CustomerData.builder()
            .id(2)
            .name("John")
            .surname("Doe")
            .age(19)
            .cash(BigDecimal.TEN)
            .products(List.of(1L,3L, 4L))
            .build();
}
