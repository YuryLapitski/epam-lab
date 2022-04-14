package com.epam.esm.dao;

import com.epam.esm.entity.GiftCertificate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GiftCertificateDao {
    GiftCertificate create(GiftCertificate entity);

    List<GiftCertificate> findAll();

    Optional<GiftCertificate> findById(long id);

    boolean delete(long id);

    GiftCertificate update(long id, Map<String, Object> paramForUpdate);

    boolean deleteGiftCertificateByName(String name);
}
