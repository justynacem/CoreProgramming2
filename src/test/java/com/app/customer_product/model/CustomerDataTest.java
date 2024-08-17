package com.app.customer_product.model;

import com.app.customer_product.data.model.CustomerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerDataTest {
    @Test
    @DisplayName("when conversion from CustomerData to Customer works")
    void whenConversionFromCustomerDataToCustomerWorks() {
        var customersData = new CustomerData(
                1,
                "Jane",
                "Doe",
                20,
                BigDecimal.ONE,
                List.of(1L, 2L, 3L)
        );

        var expectedCustomer = new Customer(
                1,
                "Jane",
                "Doe",
                20,
                BigDecimal.ONE,
                List.of(1L, 2L, 3L)
        );

        assertThat(customersData.toCustomer()).isEqualTo(expectedCustomer);
    }
}
