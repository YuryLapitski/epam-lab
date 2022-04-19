package com.epam.esm.service;

import com.epam.esm.entity.TagToGiftCertificateRelation;
import com.epam.esm.service.dto.GiftCertificateDto;
import java.util.List;

public interface TagToGiftCertificateService {
    TagToGiftCertificateRelation createTagToGiftCertificateRelation(long giftCertificateId, long tagId);

    List<GiftCertificateDto> findGiftCertificatesByTagName(String tagName);
}
