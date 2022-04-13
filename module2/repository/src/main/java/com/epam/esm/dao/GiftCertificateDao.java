package com.epam.esm.dao;

import com.epam.esm.entity.impl.GiftCertificate;

import java.util.Map;

public interface GiftCertificateDao extends EntityDao<GiftCertificate> {

    GiftCertificate update(long id, Map<String, Object> paramForUpdate);

    boolean deleteGiftCertificateByName(String name);
}
