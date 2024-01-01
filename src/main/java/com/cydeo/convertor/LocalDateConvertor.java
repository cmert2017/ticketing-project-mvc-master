/*
package com.cydeo.convertor;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@ConfigurationPropertiesBinding
public class LocalDateConvertor implements Converter<String, LocalDate>{

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source);
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super LocalDate, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}

*/
