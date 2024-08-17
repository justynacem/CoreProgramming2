package com.app.customer_product.data.json.deserializer.impl;

import com.app.customer_product.model.Products;
import com.app.customer_product.data.json.converter.JsonConverter;
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

import static com.app.customer_product.Products.HARRY_POTTER_PRODUCT;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ProductsJsonDeserializerTest {
    @Mock
    private JsonConverter<Products> productsJsonConverter;

    @InjectMocks
    private ProductsDataJsonDeserializer productsDataJsonDeserializer;

    @Test
    @DisplayName("when ProductsDataJsonDeserializer works")
    void whenProductsDataJsonDeserializerWorks() {
        var expectedProduct = new Products(
                List.of(HARRY_POTTER_PRODUCT.toProduct())
        );
        Mockito
                .when(productsJsonConverter.fromJson(
                        ArgumentMatchers.any(FileReader.class),
                        ArgumentMatchers.any()))
                .thenReturn(expectedProduct);
        var filePath = Paths
                .get("src", "test", "resources", "products-test.json")
                .toFile()
                .getAbsolutePath();
        assertEquals(expectedProduct, productsDataJsonDeserializer.deserialize(filePath));
    }
}
