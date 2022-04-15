package com.epam.esm.service.impl;

import com.epam.esm.entity.Tag;
import com.epam.esm.repository.dao.GiftCertificateDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.repository.dao.TagDao;
import com.epam.esm.repository.dao.TagToGiftCertificateDao;
import com.epam.esm.service.dto.GiftCertificateDto;
import com.epam.esm.service.exception.FieldValidationException;
import com.epam.esm.service.exception.GiftCertificateAlreadyExistException;
import com.epam.esm.service.exception.GiftCertificateNotFoundException;
import com.epam.esm.service.GiftCertificateService;
import com.epam.esm.service.validator.GiftCertificateValidator;
import com.epam.esm.service.validator.TagValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class GiftCertificateServiceImpl implements GiftCertificateService {
    private static final String GIFT_CERTIFICATE_ID_NOT_FOUND_MSG = "Gift certificate with id=%d not found.";
    private static final String GIFT_CERTIFICATE_NAME_NOT_FOUND_MSG = "Gift certificate with name '%s' not found.";
    private static final String GIFT_CERTIFICATE_ALREADY_EXIST_MSG = "Gift certificate with the name '%s' already exists";
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
    private static final double ZERO_PRICE = 0.0;
    private static final double ZERO_DURATION = 0;
    private final GiftCertificateDao giftCertificateDao;
    private final TagDao tagDao;
    private final TagToGiftCertificateDao tagToGiftCertificateDao;
    private final GiftCertificateValidator giftCertificateValidator;
    private final TagValidator tagValidator;


    @Autowired
    public GiftCertificateServiceImpl(GiftCertificateDao giftCertificateDao,
                                      TagDao tagDao,
                                      TagToGiftCertificateDao tagToGiftCertificateDao, GiftCertificateValidator giftCertificateValidator,
                                      TagValidator tagValidator) {
        this.giftCertificateDao = giftCertificateDao;
        this.tagDao = tagDao;
        this.tagToGiftCertificateDao = tagToGiftCertificateDao;
        this.giftCertificateValidator = giftCertificateValidator;
        this.tagValidator = tagValidator;
    }

    @Transactional
    @Override
    public GiftCertificateDto create(GiftCertificateDto giftCertificateDto) {
        fieldValidation(giftCertificateDto);
        isGiftCertificateExist(giftCertificateDto);
        GiftCertificate giftCertificate = giftCertificateDao.create(giftCertificateDto.getGiftCertificate());
        List<Tag> tagList = createTagsList(giftCertificateDto);
        giftCertificateDto.setGiftCertificate(giftCertificate);
        giftCertificateDto.setTags(tagList);
        return giftCertificateDto;
    }

    private boolean isValidTags(List<Tag> tags) {
        return tags.stream().allMatch(tag -> tagValidator.isNameValid(tag.getName()));
    }

    private boolean isValidGiftCertificate(GiftCertificate giftCertificate) {
        return giftCertificateValidator.validateAll(giftCertificate.getName(),
                giftCertificate.getDescription(),
                giftCertificate.getPrice(),
                giftCertificate.getDuration());
    }

    private void fieldValidation(GiftCertificateDto giftCertificateDto) {
        if (!isValidGiftCertificate(giftCertificateDto.getGiftCertificate())
                || !isValidTags(giftCertificateDto.getTags())) {
            throw new FieldValidationException(INVALID_FIELDS_MSG);
        }
    }

    private void isGiftCertificateExist(GiftCertificateDto giftCertificateDto) {
        String giftCertificateName = giftCertificateDto.getGiftCertificate().getName();
        if (giftCertificateDao.findByName(giftCertificateName).isPresent()) {
            throw new GiftCertificateAlreadyExistException(String
                    .format(GIFT_CERTIFICATE_ALREADY_EXIST_MSG, giftCertificateName));
        }
    }

    private List<Tag> createTagsList(GiftCertificateDto giftCertificateDto) {
        GiftCertificate giftCertificate = giftCertificateDto.getGiftCertificate();
        List<Tag> tagList = new ArrayList<>();
        for (Tag tag : giftCertificateDto.getTags()) {
            if (tagDao.findByName(tag.getName()).isPresent()) {
                tagList.add(tagDao.findByName(tag.getName()).get());
            } else {
                tagList.add(tagDao.create(tag));
            }
            long tagId = tagDao.findByName(tag.getName()).get().getId();
            tagToGiftCertificateDao.createTagToGiftCertificateRelation(tagId, giftCertificate.getId());
        }
        return tagList;
    }

    private Tag createTag(Tag tag) {
        return tagDao.create(tag);
    }

    @Override
    public List<GiftCertificate> findAll() {
        return giftCertificateDao.findAll();
    }

    @Override
    public GiftCertificate findById(long id) {
        return giftCertificateDao.findById(id).orElseThrow(() -> new GiftCertificateNotFoundException(String
                .format(GIFT_CERTIFICATE_ID_NOT_FOUND_MSG, id)));
    }

    @Override
    public List<GiftCertificate> findByPartOfName(String name) {
        if (giftCertificateDao.findByPartOfName(name).isEmpty()) {
            throw new GiftCertificateNotFoundException(String.format(GIFT_CERTIFICATE_NAME_NOT_FOUND_MSG, name));
        }
        return giftCertificateDao.findByPartOfName(name);
    }

    @Transactional
    @Override
    public boolean delete(long id) {
        Optional<GiftCertificate> optionalGiftCertificate = giftCertificateDao.findById(id);
        if (optionalGiftCertificate.isPresent()) {
            tagToGiftCertificateDao.deleteByGiftCertificateId(id);
            return giftCertificateDao.delete(id);
        } else {
            String msg = String.format(GIFT_CERTIFICATE_ID_NOT_FOUND_MSG, id);
            throw new GiftCertificateNotFoundException(msg);
        }
    }

    @Transactional
    @Override
    public GiftCertificate update(GiftCertificate entity) {
        if (giftCertificateDao.findById(entity.getId()).isPresent()) {
            Map<String, Object> paramMap = fillMap(entity);
            return giftCertificateDao.update(entity.getId(), paramMap);
        } else {
            String msg = String.format(GIFT_CERTIFICATE_ID_NOT_FOUND_MSG, entity.getId());
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
        if (giftCertificate.getPrice() != ZERO_PRICE) {
            if (!giftCertificateValidator.isPriceValid(giftCertificate.getPrice())) {
                throw new FieldValidationException(INVALID_PRICE_MSG);
            }
            filledMap.put(PRICE, giftCertificate.getPrice());
        }
        if (giftCertificate.getDuration() != ZERO_DURATION) {
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
