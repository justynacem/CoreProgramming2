package com.app.customer_product.converter.client.impl;

import com.app.customer_product.converter.client.FileToCustomersConverter;
import com.app.customer_product.data.json.deserializer.JsonDeserializer;
import com.app.customer_product.data.model.CustomerData;
import com.app.customer_product.data.model.CustomersData;
import com.app.customer_product.validation.impl.ClientDataValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;
import java.util.List;

import static com.app.customer_product.Customers.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class JsonFileToCustomersConverterImplTest {

    @Mock
    private JsonDeserializer<CustomersData> clientsDataJsonDeserializer;

    private FileToCustomersConverter fileToClientsConverter;

    @BeforeEach
    void setUp() {
        var validator = new ClientDataValidator("[a-zA-Z]+");

        fileToClientsConverter
                = new JsonFileToCustomersConverterImpl(clientsDataJsonDeserializer, validator);
    }

    @Test
    @DisplayName("when all data is correct")
    void whenAllDataIsCorrect() {
        Mockito
                .when(clientsDataJsonDeserializer.deserialize(ArgumentMatchers.anyString()))
                .thenReturn(new CustomersData(List.of(
                        JANE_DOE_DATA,
                        JOHN_DOE_DATA
                )));

        Assertions
                .assertThat(fileToClientsConverter.convert("customers.json"))
                .hasSize(2);
    }

    @Test
    @DisplayName("when not all data is correct")
    void whenNotAllDataIsCorrect() {
        Mockito
                .when(clientsDataJsonDeserializer.deserialize(ArgumentMatchers.anyString()))
                .thenReturn(new CustomersData(List.of(
                        CustomerData.builder()
                                .name("Jane")
                                .surname("Doe")
                                .age(15)
                                .cash(BigDecimal.ONE)
                                .products(List.of())
                                .build(),
                        JANE_DOE_DATA
                )));

        Assertions
                .assertThat(fileToClientsConverter.convert("customers.json"))
                .hasSize(1)
                .containsOnly(JANE_DOE_DATA.toCustomer());
    }
}
