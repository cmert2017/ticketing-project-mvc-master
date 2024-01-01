package com.cydeo.convertor;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDTOConvertor implements Converter<String, UserDTO> {

    UserService userService;

    public UserDTOConvertor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        return userService.findById(source);
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super UserDTO, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
