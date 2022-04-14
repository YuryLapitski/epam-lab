package com.epam.esm.validator.impl;

import com.epam.esm.validator.GiftCertificateValidator;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class GiftCertificateValidatorImpl implements GiftCertificateValidator {
    private static final Pattern NAME_PATTERN = Pattern.compile("[a-zA-Z]{2,50}");
    private static final Pattern DESCRIPTION_PATTERN = Pattern.compile("[a-zA-Z0-9.,!?&-]{2,100}");
    private static final double MIN_PRICE = 0.0;
    private static final double MAX_PRICE = 9999.99;
    private static final short MIN_DURATION = 0;
    private static final short MAX_DURATION = 365;
    private static final String SPACE_REGEX = "\\s+";
    private static final String EMPTY_STRING = "";

    @Override
    public boolean isNameValid(String name) {
        Matcher matcher = NAME_PATTERN.matcher(name.replaceAll(SPACE_REGEX, EMPTY_STRING));
        return matcher.matches();
    }

    @Override
    public boolean isDescriptionValid(String description) {
        Matcher matcher = DESCRIPTION_PATTERN.matcher(description.replaceAll(SPACE_REGEX, EMPTY_STRING));
        return matcher.matches();
    }

    @Override
    public boolean isPriceValid(double price) {
        return price >= MIN_PRICE && price <= MAX_PRICE;
    }

    @Override
    public boolean isDurationValid(short duration) {
        return duration >= MIN_DURATION && duration <= MAX_DURATION;
    }

    public boolean validateAll(String name, String description, double price, short duration){
        return isNameValid(name)
                && isDescriptionValid(description)
                && isPriceValid(price)
                && isDurationValid(duration);
    }
}
