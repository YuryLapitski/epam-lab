package com.epam.esm.dao.impl;

import com.epam.esm.dao.TagToGiftCertificate;
import com.epam.esm.entity.impl.TagToGiftCertificateRelation;

import java.util.List;
import java.util.Optional;

public class TagToGiftCertificateDaoImpl implements TagToGiftCertificate {
    @Override
    public TagToGiftCertificateRelation create(TagToGiftCertificateRelation entity) {
        return null;
    }

    @Override
    public List<TagToGiftCertificateRelation> findAll() {
        return null;
    }

    @Override
    public Optional<TagToGiftCertificateRelation> findById(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
