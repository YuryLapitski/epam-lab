package com.epam.esm.dao;

import com.epam.esm.entity.impl.GiftCertificate;

public interface GiftCertificateDao extends EntityDao<GiftCertificate> {

    GiftCertificate update(GiftCertificate entity);

    boolean deleteGiftCertificateByName(String name);
}
