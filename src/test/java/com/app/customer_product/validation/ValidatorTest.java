package com.app.customer_product.validation;

import com.app.customer_product.data.model.CustomerData;
import com.app.customer_product.validation.impl.ClientDataValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @Test
    @DisplayName("when validation is ok")
    void whenValidationIsOk() {

        var validator = new ClientDataValidator("[a-zA-Z]+");

        var clientData = CustomerData.builder()
                .name("Jane")
                .surname("Doe")
                .age(18)
                .cash(BigDecimal.ONE)
                .products(List.of())
                .build();
        assertThat(Validator.validate(clientData, validator)).isTrue();
    }

    @Test
    @DisplayName("when validation is not ok")
    void whenValidationIsNotOk() {
        var validator = new ClientDataValidator("[a-zA-Z]+");

        var clientData = CustomerData.builder()
                .name("Jane2")
                .surname("Doe")
                .age(17)
                .cash(BigDecimal.ONE)
                .products(List.of())
                .build();
        assertThat(Validator.validate(clientData, validator)).isFalse();
    }
}

