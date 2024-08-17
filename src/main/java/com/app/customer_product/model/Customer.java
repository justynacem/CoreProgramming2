package com.app.customer_product.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record Customer(long id, String name, String surname, int age, BigDecimal cash, List<Long> products) {
}
