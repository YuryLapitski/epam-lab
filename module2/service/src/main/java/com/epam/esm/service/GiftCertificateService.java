package com.epam.esm.service;

import com.epam.esm.entity.impl.GiftCertificate;
import com.epam.esm.entity.impl.Tag;

import java.util.List;
import java.util.Optional;

public interface GiftCertificateService {
    GiftCertificate create(GiftCertificate giftCertificate);

    List<GiftCertificate> findAll();

    Optional<GiftCertificate> findById(long id);

    boolean delete(long id);

    GiftCertificate update(GiftCertificate entity);
}
