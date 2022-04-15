package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.service.dto.GiftCertificateDto;

import java.util.List;
import java.util.Optional;

public interface GiftCertificateService {
    GiftCertificateDto create(GiftCertificateDto giftCertificateDto);

    List<GiftCertificate> findAll();

    GiftCertificate findById(long id);

    List<GiftCertificate> findByPartOfName(String name);

    boolean delete(long id);

    GiftCertificate update(GiftCertificate entity);
}
