package com.epam.esm.repository.dao;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.entity.TagToGiftCertificateRelation;

import java.util.List;
import java.util.Set;

public interface TagToGiftCertificateDao {
    TagToGiftCertificateRelation createTagToGiftCertificateRelation(long giftCertificateId, long tagId);

    List<GiftCertificate> findGiftCertificatesByTagName(String tagName);

    List<TagToGiftCertificateRelation> findByTagId(long tagID);

    List<Tag> findByGiftCertificateId(long giftCertificateId);

    boolean deleteByGiftCertificateId(long giftCertificateId);
}
