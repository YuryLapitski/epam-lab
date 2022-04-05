package com.epam.esm.gift.dao.impl;

import com.epam.esm.gift.dao.GiftCertificateDao;
import com.epam.esm.gift.entity.impl.GiftCertificate;

import java.util.List;
import java.util.Optional;

public class GiftCertificateDaoImpl implements GiftCertificateDao {
    @Override
    public GiftCertificate create(GiftCertificate entity) {
        return null;
    }

    @Override
    public List<GiftCertificate> findAll() {
        return null;
    }

    @Override
    public Optional<GiftCertificate> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public GiftCertificate update(GiftCertificate entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
