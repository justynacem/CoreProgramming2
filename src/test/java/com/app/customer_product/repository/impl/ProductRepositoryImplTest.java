package com.app.customer_product.repository.impl;

import com.app.customer_product.converter.client.impl.JsonFileToProductsConverterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static com.app.customer_product.Products.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ProductRepositoryImplTest {

    @Mock
    private JsonFileToProductsConverterImpl jsonFileToProductsConverter;

    private ProductRepositoryImpl productRepository;

    @BeforeEach
    void setUp() {
        var products = List.of(
                COMPUTER_PRODUCT.toProduct(),
                WAR_AND_PEACE_PRODUCT.toProduct(),
                TABLET_PRODUCT.toProduct(),
                CAMERA_PRODUCT.toProduct(),
                HARRY_POTTER_PRODUCT.toProduct(),
                BALL_PRODUCT.toProduct(),
                SWIMMING_SUIT_PRODUCT.toProduct());
        var filename = "products.json";
        when(jsonFileToProductsConverter.convert(ArgumentMatchers.anyString()))
                .thenReturn(products);

        productRepository = new ProductRepositoryImpl(jsonFileToProductsConverter, filename);
    }

    @Test
    @DisplayName("when fetching all data works")
    void whenFetchingAllDataWorks() {
        assertThat(productRepository.getAll())
                .hasSize(7)
                .isEqualTo(List.of(
                        COMPUTER_PRODUCT.toProduct(),
                        WAR_AND_PEACE_PRODUCT.toProduct(),
                        TABLET_PRODUCT.toProduct(),
                        CAMERA_PRODUCT.toProduct(),
                        HARRY_POTTER_PRODUCT.toProduct(),
                        BALL_PRODUCT.toProduct(),
                        SWIMMING_SUIT_PRODUCT.toProduct()
                ));
    }
}
