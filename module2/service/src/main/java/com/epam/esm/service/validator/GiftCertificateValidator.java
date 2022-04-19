package com.epam.esm.service.validator;

import java.math.BigDecimal;

public interface GiftCertificateValidator {
    boolean isNameValid(String name);

    boolean isDescriptionValid(String description);

    boolean isPriceValid(BigDecimal price);

    boolean isDurationValid(short duration);

    boolean validateAll(String name, String description, BigDecimal price, short duration);

    boolean isSortTypeValid(String sortType);

    boolean isColumnNameValid(String columnName);
}
