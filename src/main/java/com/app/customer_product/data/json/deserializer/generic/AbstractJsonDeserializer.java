package com.app.customer_product.data.json.deserializer.generic;

import com.app.customer_product.data.json.converter.JsonConverter;
import com.app.customer_product.data.json.deserializer.JsonDeserializer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.lang.reflect.ParameterizedType;

@RequiredArgsConstructor
public abstract class AbstractJsonDeserializer<T> implements JsonDeserializer<T> {
    private final JsonConverter<T> converter;

    @SuppressWarnings("unchecked")
    private final Class<T> type =
            (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @SneakyThrows
    @Override
    public T deserialize(String filename) {
        try (var reader = new FileReader(filename)) {
            return converter.fromJson(reader, type);
        }
    }
}
