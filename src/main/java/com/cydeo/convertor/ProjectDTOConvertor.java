package com.cydeo.convertor;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.ProjectService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ProjectDTOConvertor implements Converter<String, ProjectDTO> {

    ProjectService projectService;

    public ProjectDTOConvertor(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String source) {
        return projectService.findById(source);
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super ProjectDTO, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
