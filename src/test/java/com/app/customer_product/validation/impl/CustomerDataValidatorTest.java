package com.app.customer_product.validation.impl;

import com.app.customer_product.data.model.CustomerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerDataValidatorTest {

    static Stream<Arguments> validationData() {
        return Stream.of(
                Arguments.of(
                        CustomerData.builder()
                                .name("Jane2")
                                .surname("Doe")
                                .age(18)
                                .cash(BigDecimal.ONE)
                                .products(List.of())
                                .build(),
                        Map.of("name", "does not match regex: Jane2")
                ),
                Arguments.of(
                        CustomerData.builder()
                                .name("Jane")
                                .surname("Do2e")
                                .age(18)
                                .cash(BigDecimal.ONE)
                                .products(List.of())
                                .build(),
                        Map.of("surname", "does not match regex: Do2e")
                ),
                Arguments.of(
                        CustomerData.builder()
                                .name("Jane")
                                .surname("Doe")
                                .age(16)
                                .cash(BigDecimal.ONE)
                                .products(List.of())
                                .build(),
                        Map.of("age", "must be higher than 18: 16")
                ),
                Arguments.of(
                        CustomerData.builder()
                                .name("Jane")
                                .surname("Doe")
                                .age(18)
                                .cash(BigDecimal.valueOf(-100))
                                .products(List.of())
                                .build(),
                        Map.of("cash", "must be positive: -100")
                ),
                Arguments.of(
                        CustomerData.builder()
                                .name("Jane2")
                                .surname("Doe")
                                .age(18)
                                .cash(BigDecimal.valueOf(-100))
                                .products(List.of())
                                .build(),
                        Map.of(
                                "cash", "must be positive: -100",
                                "name", "does not match regex: Jane2"
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("validationData")
    @DisplayName("when validation result is not correct")
    void whenValidationResultIsNotCorrect(CustomerData customerData, Map<String, String> expectedErrors) {
        var validator = new ClientDataValidator("[a-zA-Z]+");
        assertThat(validator.validate(customerData))
                .isEqualTo(expectedErrors);
    }

}
