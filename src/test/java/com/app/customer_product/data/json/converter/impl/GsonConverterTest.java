package com.app.customer_product.data.json.converter.impl;

import com.app.customer_product.data.extension.FileReaderExtension;
import com.app.customer_product.data.model.CustomersData;

import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.app.customer_product.Customers.JANE_DOE_DATA;

@ExtendWith(FileReaderExtension.class)
@RequiredArgsConstructor
class GsonConverterTest {

    private final FileReader fileReader;

    @Test
    @SneakyThrows
    @DisplayName("When json serialization works")
    void whenJsonSerializationWorks() {
        var filePath = Paths
                .get("src", "test", "resources", "customers-created-test.json")
                .toFile()
                .getAbsolutePath();
        var fileWriter = new FileWriter(filePath);
        var gson = new GsonBuilder().create();
        var gsonConverter = new GsonConverter<CustomersData>(gson);
        Assertions.assertDoesNotThrow(() -> gsonConverter
                .toJson(new CustomersData(List.of(JANE_DOE_DATA)), fileWriter));

        var path = Paths.get(filePath);
        Assertions.assertTrue(Files.exists(path));
    }

    @Test
    @DisplayName("When json deserialization works")
    void whenJsonDeserializationWorks() {
        var gson = new GsonBuilder().create();
        var gsonConverter = new GsonConverter<CustomersData>(gson);
        var customers = gsonConverter.fromJson(fileReader, CustomersData.class);
        var expectedCustomer = new CustomersData(
                List.of(JANE_DOE_DATA));
        Assertions.assertEquals(expectedCustomer, customers);
    }

}
