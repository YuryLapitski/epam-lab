package com.epam.esm.service.validator;

public interface GiftCertificateValidator {
    boolean isNameValid(String name);

    boolean isDescriptionValid(String description);

    boolean isPriceValid(double price);

    boolean isDurationValid(short duration);

    boolean validateAll(String name, String description, double price, short duration);
}
