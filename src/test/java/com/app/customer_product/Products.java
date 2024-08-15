package com.app.customer_product;

import com.app.customer_product.data.model.ProductData;

import java.math.BigDecimal;

public interface Products {
    ProductData COMPUTER_PRODUCT = ProductData.builder()
            .id(1)
            .name("Computer")
            .category("Electronics")
            .price(BigDecimal.valueOf(2400))
            .build();

    ProductData WAR_AND_PEACE_PRODUCT = ProductData.builder()
            .id(2)
            .name("War and peace")
            .category("Books")
            .price(BigDecimal.valueOf(120))
            .build();

    ProductData TABLET_PRODUCT = ProductData.builder()
            .id(3)
            .name("Tablet")
            .category("Electronics")
            .price(BigDecimal.valueOf(500))
            .build();

    ProductData CAMERA_PRODUCT = ProductData.builder()
            .id(4)
            .name("Camera")
            .category("Electronics")
            .price(BigDecimal.valueOf(800))
            .build();

    ProductData HARRY_POTTER_PRODUCT = ProductData.builder()
            .id(5)
            .name("Harry Potter")
            .category("Books")
            .price(BigDecimal.valueOf(120))
            .build();

    ProductData BALL_PRODUCT = ProductData.builder()
            .id(6)
            .name("Ball")
            .category("Sport")
            .price(BigDecimal.valueOf(60))
            .build();

    ProductData SWIMMING_SUIT_PRODUCT = ProductData.builder()
            .id(7)
            .name("Swimming suit")
            .category("Soirt")
            .price(BigDecimal.valueOf(150))
            .build();
}
