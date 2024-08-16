package com.app.customer_product.converter.client.impl;

import com.app.customer_product.converter.client.FileToCustomersConverter;
import com.app.customer_product.data.json.deserializer.JsonDeserializer;
import com.app.customer_product.data.model.CustomerData;
import com.app.customer_product.data.model.CustomersData;
import com.app.customer_product.model.Customer;
import com.app.customer_product.validation.Validator;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class JsonFileToCustomersConverterImpl implements FileToCustomersConverter {

    private final JsonDeserializer<CustomersData> clientsDataJsonDeserializer;
    private final Validator<CustomerData> clientDataValidator;

    @Override
    public List<Customer> convert(String filename) {
        return clientsDataJsonDeserializer
                .deserialize(filename)
                .customers()
                .stream()
                .filter(clientData -> Validator.validate(clientData, clientDataValidator))
                .map(CustomerData::toCustomer)
                .toList();
    }
}
