package com.epam.esm.service.impl;

import com.epam.esm.entity.impl.GiftCertificate;
import com.epam.esm.entity.impl.Tag;
import com.epam.esm.service.GiftCertificateService;

import java.util.List;
import java.util.Optional;

public class GiftCertificateServiceImpl implements GiftCertificateService {

    @Override
    public GiftCertificate create(GiftCertificate giftCertificate) {
        return null;
    }

    @Override
    public List<GiftCertificate> findAll() {
        return null;
    }

    @Override
    public Optional<GiftCertificate> findById(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public GiftCertificate update(GiftCertificate entity) {
        return null;
    }
}
