package com.app.customer_product.model;

import lombok.*;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Product {
    //todo
    @Getter
    private final long id;
    private final String name;
    @Getter // do grupowania
    private final String category;
    @Getter // do comparatora
    private final BigDecimal price;

    public BigDecimal getPricePerQuantity(Integer quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public Boolean isCategory(String category) {
        return this.category.equalsIgnoreCase(category);
    }

    public BigDecimal multiplyPriceBy(Integer quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
