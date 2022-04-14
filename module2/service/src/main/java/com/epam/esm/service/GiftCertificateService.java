package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.exception.EntityNotFoundException;

import java.util.List;

public interface GiftCertificateService {
    GiftCertificate create(GiftCertificate giftCertificate);

    List<GiftCertificate> findAll();

    GiftCertificate findById(long id) throws EntityNotFoundException;

    boolean delete(long id) throws EntityNotFoundException;

    GiftCertificate update(GiftCertificate entity) throws EntityNotFoundException;
}
