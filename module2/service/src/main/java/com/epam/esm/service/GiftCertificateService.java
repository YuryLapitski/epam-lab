package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.exception.TagNotFoundException;

import java.util.List;

public interface GiftCertificateService {
    GiftCertificate create(GiftCertificate giftCertificate);

    List<GiftCertificate> findAll();

    GiftCertificate findById(long id) throws TagNotFoundException;

    boolean delete(long id) throws TagNotFoundException;

    GiftCertificate update(GiftCertificate entity) throws TagNotFoundException;
}
