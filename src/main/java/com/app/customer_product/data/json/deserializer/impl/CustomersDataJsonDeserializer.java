package com.app.customer_product.data.json.deserializer.impl;


import com.app.customer_product.data.json.converter.JsonConverter;
import com.app.customer_product.data.json.deserializer.JsonDeserializer;
import com.app.customer_product.data.json.deserializer.generic.AbstractJsonDeserializer;
import com.app.customer_product.data.model.CustomersData;

public class CustomersDataJsonDeserializer extends AbstractJsonDeserializer<CustomersData> implements JsonDeserializer<CustomersData> {
    public CustomersDataJsonDeserializer(JsonConverter<CustomersData> converter) {
        super(converter);
    }
}
