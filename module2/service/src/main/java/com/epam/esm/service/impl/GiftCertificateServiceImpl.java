package com.epam.esm.service.impl;

import com.epam.esm.dao.GiftCertificateDao;
import com.epam.esm.entity.impl.GiftCertificate;
import com.epam.esm.exception.EntityNotFoundException;
import com.epam.esm.service.GiftCertificateService;
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
    private final GiftCertificateDao giftCertificateDao;

    @Autowired
    public GiftCertificateServiceImpl(GiftCertificateDao giftCertificateDao) {
        this.giftCertificateDao = giftCertificateDao;
    }

    @Override
    public GiftCertificate create(GiftCertificate giftCertificate) {
        return giftCertificateDao.create(giftCertificate);
    }

    @Override
    public List<GiftCertificate> findAll() {
        return giftCertificateDao.findAll();
    }

    @Override
    public GiftCertificate findById(long id) throws EntityNotFoundException {
        return giftCertificateDao.findById(id).orElseThrow(() -> new EntityNotFoundException(String
                .format(GIFT_CERTIFICATE_NOT_FOUND_MSG, id)));
    }

    @Override
    public boolean delete(long id) throws EntityNotFoundException {
        Optional<GiftCertificate> optionalTag = giftCertificateDao.findById(id);
        if (optionalTag.isPresent()) {
            return giftCertificateDao.delete(id);
        } else {
            throw new EntityNotFoundException(String.format(GIFT_CERTIFICATE_NOT_FOUND_MSG, id));
        }
    }

    @Override
    public GiftCertificate update(GiftCertificate entity) throws EntityNotFoundException {
        if (giftCertificateDao.findById(entity.getId()).isPresent()) {
            Map<String, Object> paramMap = fillMap(entity);
            return giftCertificateDao.update(entity.getId(), paramMap);
        } else {
            throw new EntityNotFoundException(String.format(GIFT_CERTIFICATE_NOT_FOUND_MSG, entity.getId()));
        }
    }

    private Map<String, Object> fillMap(GiftCertificate giftCertificate) {
        Map<String, Object> filledMap = new HashMap<>();
        String name = giftCertificate.getName();
        if (name != null) {
            filledMap.put("name", name);
        }
        String description = giftCertificate.getDescription();
        if (description != null) {
            filledMap.put("description", description);
        }
        double price = giftCertificate.getPrice();
        if (price != 0.0) {
            filledMap.put("price", price);
        }
        short duration = giftCertificate.getDuration();
        if (duration != 0) {
            filledMap.put("duration", duration);
        }
        Timestamp lastUpdateDate = Timestamp.valueOf(LocalDateTime.now());
        filledMap.put("last_update_date", lastUpdateDate);

        return filledMap;
    }
}
