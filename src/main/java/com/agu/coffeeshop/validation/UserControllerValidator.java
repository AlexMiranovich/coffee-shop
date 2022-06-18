package com.agu.coffeeshop.validation;

import com.agu.coffeeshop.controllers.dto.UserCreateDto;
import com.agu.coffeeshop.exceptions.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.agu.coffeeshop.exceptions.ApiErrorCode.*;

@Service
public class UserControllerValidator {

    public void validateCreateUser(UserCreateDto createDto) {
        if (!StringUtils.hasText(createDto.getFirstName()))
            throw new BadRequestException(EMPTY_FIRST_NAME.getDefaultMessage(), EMPTY_FIRST_NAME);
        if (!StringUtils.hasText(createDto.getLastName()))
            throw new BadRequestException(EMPTY_LAST_NAME.getDefaultMessage(), EMPTY_LAST_NAME);
        if (!StringUtils.hasText(createDto.getEmail()))
            throw new BadRequestException(EMPTY_EMAIL.getDefaultMessage(), EMPTY_EMAIL);
        if (!StringUtils.hasText(createDto.getPhoneNumber()))
            throw new BadRequestException(EMPTY_PHONE_NUMBER.getDefaultMessage(), EMPTY_PHONE_NUMBER);
    }
}
