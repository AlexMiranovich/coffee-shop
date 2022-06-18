package com.agu.coffeeshop.validation;

import com.agu.coffeeshop.controllers.dto.ItemCreateDto;
import com.agu.coffeeshop.exceptions.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.agu.coffeeshop.exceptions.ApiErrorCode.*;

@Service
public class ItemControllerValidator {

    public void validateCreateItem(ItemCreateDto createDto) {
        if (!StringUtils.hasText(String.valueOf(createDto.getItemType())))
            throw new BadRequestException(EMPTY_ITEM_TYPE.getDefaultMessage(), EMPTY_ITEM_TYPE);
        if (!StringUtils.hasText(createDto.getItemName()))
            throw new BadRequestException(EMPTY_ITEM_NAME.getDefaultMessage(), EMPTY_ITEM_NAME);
        if (createDto.getPrice() == null || createDto.getPrice() < 0)
            throw new BadRequestException(ITEM_PRICE_NOT_VALID.getDefaultMessage(), ITEM_PRICE_NOT_VALID);
    }
}
