package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.service.dto.GiftCertificateDto;
import java.util.List;

public interface GiftCertificateService {
    GiftCertificateDto create(GiftCertificateDto giftCertificateDto);

    List<GiftCertificateDto> findAll();

    GiftCertificateDto findByGiftCertificateId(long id);

    List<GiftCertificateDto> findByPartOfName(String name);

    List<GiftCertificateDto> findAllWithSort(String columnName, String sortType);

    boolean delete(long id);

    GiftCertificateDto update(GiftCertificate entity);
}
