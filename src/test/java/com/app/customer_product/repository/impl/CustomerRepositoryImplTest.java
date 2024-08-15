package com.app.customer_product.repository.impl;

import com.app.customer_product.converter.client.impl.JsonFileToCustomersConverterImpl;
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
import java.util.NoSuchElementException;

import static com.app.customer_product.Customers.JANE_DOE_DATA;
import static com.app.customer_product.Customers.JOHN_DOE_DATA;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CustomerRepositoryImplTest {

    @Mock
    private JsonFileToCustomersConverterImpl jsonFileToClientsConverter;

    private CustomerRepositoryImpl clientRepository;

    @BeforeEach
    void setUp() {
        var clients = List.of(JANE_DOE_DATA.toCustomer(), JOHN_DOE_DATA.toCustomer());
        var filename = ArgumentMatchers.anyString();
        when(jsonFileToClientsConverter.convert(filename))
                .thenReturn(clients);

        clientRepository = new CustomerRepositoryImpl(jsonFileToClientsConverter, filename);
    }

    @Test
    @DisplayName("when fetching all data works")
    void whenFetchingAllDataWorks() {
        assertThat(clientRepository.getAll())
                .hasSize(2)
                .isEqualTo(List.of(JANE_DOE_DATA.toCustomer(), JOHN_DOE_DATA.toCustomer()));
    }

    @Test
    @DisplayName("when fetching by id works")
    void whenFetchingByIdWorks() {
        assertThat(clientRepository.getById(1L))
                .isEqualTo(JANE_DOE_DATA.toCustomer());
    }

    @Test
    @DisplayName("when Customer with id not found")
    void whenCustomerWithIdNotFound() {
        assertThatThrownBy(() -> clientRepository.getById(10L))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Customer with id 10 not found");
    }
}
