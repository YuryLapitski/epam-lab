package com.epam.esm.repository.dao;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.TagToGiftCertificateRelation;

import java.util.List;

public interface TagToGiftCertificateDao {
    TagToGiftCertificateRelation createTagToGiftCertificateRelation(long giftCertificateId, long tagId);

    List<GiftCertificate> findGiftCertificatesByTagName(String tagName);

    List<TagToGiftCertificateRelation> findByTagId(long tagID);

    void deleteByGiftCertificateId(long giftCertificateId);
}
