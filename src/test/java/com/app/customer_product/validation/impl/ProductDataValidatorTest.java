package com.app.customer_product.validation.impl;

import com.app.customer_product.data.model.ProductData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ProductDataValidatorTest {

    static Stream<Arguments> validationData() {
        return Stream.of(
                Arguments.of(
                        ProductData.builder()
                                .name("Harry - Potter")
                                .category("Books")
                                .price(BigDecimal.ONE)
                                .build(),
                        Map.of("name", "does not match regex: Harry - Potter")
                ),
                Arguments.of(
                        ProductData.builder()
                                .name("Harry Potter")
                                .category("Books 1")
                                .price(BigDecimal.ONE)
                                .build(),
                        Map.of("category", "does not match regex: Books 1")
                ),
                Arguments.of(
                        ProductData.builder()
                                .name("Harry Potter")
                                .category("Books")
                                .price(BigDecimal.valueOf(-20))
                                .build(),
                        Map.of("price", "must be positive: -20")
                ),
                Arguments.of(
                        ProductData.builder()
                                .name("Harry Potter")
                                .category("Books 1")
                                .price(BigDecimal.valueOf(-20))
                                .build(),
                        Map.of(
                                "category", "does not match regex: Books 1",
                                "price", "must be positive: -20"
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("validationData")
    @DisplayName("when validation result is not correct")
    void whenValidationResultIsNotCorrect(ProductData productData, Map<String, String> expectedErrors) {
        var validator = new ProductDataValidator("[a-zA-Z ]+");
        assertThat(validator.validate(productData))
                .isEqualTo(expectedErrors);
    }
}
