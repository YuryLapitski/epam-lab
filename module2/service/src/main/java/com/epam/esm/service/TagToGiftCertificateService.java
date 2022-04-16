package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.TagToGiftCertificateRelation;
import java.util.List;

public interface TagToGiftCertificateService {
    TagToGiftCertificateRelation createTagToGiftCertificateRelation(long giftCertificateId, long tagId);

    List<GiftCertificate> findGiftCertificatesByTagName(String tagName);
}
