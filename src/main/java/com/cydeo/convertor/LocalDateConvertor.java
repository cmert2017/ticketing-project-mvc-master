package com.cydeo.convertor;

import com.cydeo.service.ProjectService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@ConfigurationPropertiesBinding
public class LocalDateConvertor implements Converter<String, LocalDate>{

    ProjectService projectService;

    public LocalDateConvertor(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source);
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super LocalDate, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
