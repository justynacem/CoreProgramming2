package com.app.customer_product.data.json.deserializer.impl;


import com.app.customer_product.data.json.converter.JsonConverter;
import com.app.customer_product.data.json.deserializer.JsonDeserializer;
import com.app.customer_product.data.json.deserializer.generic.AbstractJsonDeserializer;
import com.app.customer_product.data.model.CustomersData;
import com.app.customer_product.data.model.ProductsData;

public class ProductsDataJsonDeserializer extends AbstractJsonDeserializer<ProductsData> implements JsonDeserializer<ProductsData> {
    public ProductsDataJsonDeserializer(JsonConverter<ProductsData> converter) {
        super(converter);
    }
}
