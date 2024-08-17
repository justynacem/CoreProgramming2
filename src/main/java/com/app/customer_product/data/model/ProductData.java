package com.app.customer_product.data.model;

import com.app.customer_product.model.Product;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductData(
        long id,
        String name,
        String category,
        BigDecimal price
) {
    public Product toProduct() {
        return Product
                .builder()
                .id(id)
                .name(name)
                .category(category)
                .price(price)
                .build();
    }
}
