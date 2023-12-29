package com.cydeo.convertor;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDtoConvertor implements Converter<String, RoleDTO> {

    RoleService roleService;

    //binding
    public RoleDtoConvertor(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {
        return roleService.findById(Long.parseLong(source));
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super RoleDTO, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
