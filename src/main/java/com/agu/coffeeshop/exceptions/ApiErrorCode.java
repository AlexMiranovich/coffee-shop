package com.agu.coffeeshop.exceptions;

public enum ApiErrorCode {

    EMPTY_FIRST_NAME("First name is empty"),
    EMPTY_LAST_NAME("Last name is empty"),
    EMPTY_EMAIL("Email is empty"),
    EMPTY_PHONE_NUMBER("Phone number is empty"),
    EMPTY_ITEM_TYPE("Item type is empty"),
    EMPTY_ITEM_NAME("Item name is empty"),
    ITEM_PRICE_NOT_VALID("Item price not valid");

    private final String defaultMessage;

    ApiErrorCode(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
