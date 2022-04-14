package com.epam.esm.service.impl;

import com.epam.esm.dao.TagToGiftCertificateDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.TagToGiftCertificateRelation;
import com.epam.esm.service.TagToGiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagToGiftCertificateServiceImpl implements TagToGiftCertificateService {
    private final TagToGiftCertificateDao tagToGiftCertificateDao;

    @Autowired
    public TagToGiftCertificateServiceImpl(TagToGiftCertificateDao tagToGiftCertificateDao) {
        this.tagToGiftCertificateDao = tagToGiftCertificateDao;
    }

    @Override
    public TagToGiftCertificateRelation createTagToGiftCertificateRelation(long giftCertificateId, long tagId) {
        return tagToGiftCertificateDao.createTagToGiftCertificateRelation(giftCertificateId, tagId);
    }

    @Override
    public List<GiftCertificate> getGiftCertificateByTagName(String tagName) {
        return tagToGiftCertificateDao.getGiftCertificateByTagName(tagName);
    }
}
