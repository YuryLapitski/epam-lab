package com.epam.esm.service.impl;

import com.epam.esm.dao.GiftCertificateDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.exception.FieldValidationException;
import com.epam.esm.exception.GiftCertificateNotFoundException;
import com.epam.esm.service.GiftCertificateService;
import com.epam.esm.validator.GiftCertificateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GiftCertificateServiceImpl implements GiftCertificateService {
    private static final String GIFT_CERTIFICATE_NOT_FOUND_MSG = "Gift certificate with id=%d not found.";
    private static final String INVALID_FIELDS_MSG = "Invalid fields";
    private static final String INVALID_NAME_MSG = "Invalid name";
    private static final String INVALID_DESCRIPTION_MSG = "Invalid description";
    private static final String INVALID_PRICE_MSG = "Invalid price";
    private static final String INVALID_DURATION_MSG = "Invalid duration";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String DURATION = "duration";
    private static final String LAST_UPDATE_DATE = "last_update_date";
    private final GiftCertificateDao giftCertificateDao;
    private final GiftCertificateValidator giftCertificateValidator;

    @Autowired
    public GiftCertificateServiceImpl(GiftCertificateDao giftCertificateDao,
                                      GiftCertificateValidator giftCertificateValidator) {
        this.giftCertificateDao = giftCertificateDao;
        this.giftCertificateValidator = giftCertificateValidator;
    }

    @Override
    public GiftCertificate create(GiftCertificate giftCertificate) {
        if (!giftCertificateValidator.validateAll(giftCertificate.getName(),
                giftCertificate.getDescription(),
                giftCertificate.getPrice(),
                giftCertificate.getDuration())) {
            throw new FieldValidationException(INVALID_FIELDS_MSG);
        }
        return giftCertificateDao.create(giftCertificate);
    }

    @Override
    public List<GiftCertificate> findAll() {
        return giftCertificateDao.findAll();
    }

    @Override
    public GiftCertificate findById(long id) {
        return giftCertificateDao.findById(id).orElseThrow(() -> new GiftCertificateNotFoundException(String
                .format(GIFT_CERTIFICATE_NOT_FOUND_MSG, id)));
    }

    @Override
    public boolean delete(long id) {
        Optional<GiftCertificate> optionalGiftCertificate = giftCertificateDao.findById(id);
        if (optionalGiftCertificate.isPresent()) {
            return giftCertificateDao.delete(id);
        } else {
            String msg = String.format(GIFT_CERTIFICATE_NOT_FOUND_MSG, id);
            throw new GiftCertificateNotFoundException(msg);
        }
    }

    @Override
    public GiftCertificate update(GiftCertificate entity) {
        if (giftCertificateDao.findById(entity.getId()).isPresent()) {
            Map<String, Object> paramMap = fillMap(entity);
            return giftCertificateDao.update(entity.getId(), paramMap);
        } else {
            String msg = String.format(GIFT_CERTIFICATE_NOT_FOUND_MSG, entity.getId());
            throw new GiftCertificateNotFoundException(msg);
        }
    }

    private Map<String, Object> fillMap(GiftCertificate giftCertificate) {
        Map<String, Object> filledMap = new HashMap<>();
        if (giftCertificate.getName() != null) {
            if (!giftCertificateValidator.isNameValid(giftCertificate.getName())) {
                throw new FieldValidationException(INVALID_NAME_MSG);
            }
            filledMap.put(NAME, giftCertificate.getName());
        }
        if (giftCertificate.getDescription() != null) {
            if (!giftCertificateValidator.isDescriptionValid(giftCertificate.getDescription())) {
                throw new FieldValidationException(INVALID_DESCRIPTION_MSG);
            }
            filledMap.put(DESCRIPTION, giftCertificate.getDescription());
        }
        if (giftCertificate.getPrice() != 0.0) {
            if (!giftCertificateValidator.isPriceValid(giftCertificate.getPrice())) {
                throw new FieldValidationException(INVALID_PRICE_MSG);
            }
            filledMap.put(PRICE, giftCertificate.getPrice());
        }
        if (giftCertificate.getDuration() != 0) {
            if (!giftCertificateValidator.isDurationValid(giftCertificate.getDuration())) {
                throw new FieldValidationException(INVALID_DURATION_MSG);
            }
            filledMap.put(DURATION, giftCertificate.getDuration());
        }

        Timestamp lastUpdateDate = Timestamp.valueOf(LocalDateTime.now());
        filledMap.put(LAST_UPDATE_DATE, lastUpdateDate);

        return filledMap;
    }
}
