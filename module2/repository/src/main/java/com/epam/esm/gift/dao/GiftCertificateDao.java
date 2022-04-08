package com.epam.esm.gift.dao;

import com.epam.esm.gift.entity.impl.GiftCertificate;

public interface GiftCertificateDao extends EntityDao<GiftCertificate> {

    GiftCertificate update(GiftCertificate entity);

    boolean deleteGiftCertificateByName(String name);
}
