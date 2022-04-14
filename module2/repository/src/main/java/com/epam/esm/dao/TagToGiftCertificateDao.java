package com.epam.esm.dao;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.TagToGiftCertificateRelation;

import java.util.List;

public interface TagToGiftCertificateDao {
    TagToGiftCertificateRelation createTagToGiftCertificateRelation(long giftCertificateId, long tagId);

    List<GiftCertificate> getGiftCertificateByTagName(String tagName);
}
