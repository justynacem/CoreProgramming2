package com.app.customer_product.data.json.deserializer.impl;

import com.app.customer_product.data.json.converter.JsonConverter;
import com.app.customer_product.model.Customers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.List;

import static com.app.customer_product.Customers.JANE_DOE_DATA;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CustomersJsonDeserializerTest {
    @Mock
    private JsonConverter<Customers> customersJsonConverter;

    @InjectMocks
    private CustomersDataJsonDeserializer customersDataJsonDeserializer;

    @Test
    @DisplayName("when CustomersDataJsonDeserializer works")
    void whenCustomersDataJsonDeserializerWorks() {
        var expectedClient = new Customers(
                List.of(JANE_DOE_DATA.toCustomer()));
        Mockito
                .when(customersJsonConverter.fromJson(
                        ArgumentMatchers.any(FileReader.class),
                        ArgumentMatchers.any()))
                .thenReturn(expectedClient);
        var filePath = Paths
                .get("src", "test", "resources", "customers-test.json")
                .toFile()
                .getAbsolutePath();
        assertEquals(expectedClient, customersDataJsonDeserializer.deserialize(filePath));
    }
}
