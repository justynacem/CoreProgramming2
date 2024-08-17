package com.app.customer_product.data.json.deserializer;

public interface JsonDeserializer<T> {
    T deserialize(String filename);
}
