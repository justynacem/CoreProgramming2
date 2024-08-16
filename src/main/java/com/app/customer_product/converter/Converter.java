package com.app.customer_product.converter;

public interface Converter<T, U> {
    U convert(T t);
}
