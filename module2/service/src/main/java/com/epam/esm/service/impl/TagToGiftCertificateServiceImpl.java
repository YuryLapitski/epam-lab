package com.epam.esm.service.impl;

import com.epam.esm.repository.dao.GiftCertificateDao;
import com.epam.esm.repository.dao.TagDao;
import com.epam.esm.repository.dao.TagToGiftCertificateDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.entity.TagToGiftCertificateRelation;
import com.epam.esm.service.exception.GiftCertificateNotFoundException;
import com.epam.esm.service.exception.GiftCertificatesNotFoundException;
import com.epam.esm.service.exception.TagNotFoundException;
import com.epam.esm.service.TagToGiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TagToGiftCertificateServiceImpl implements TagToGiftCertificateService {
    private static final String TAG_NOT_FOUND_MSG = "Tag with id=%d not found.";
    private static final String GIFT_CERTIFICATE_NOT_FOUND_MSG = "Gift certificate with id=%d not found.";
    private static final String GIFT_CERTIFICATES_NOT_FOUND_MSG = "Gift certificate with tag name '%s' not found.";
    private final TagToGiftCertificateDao tagToGiftCertificateDao;
    private final GiftCertificateDao giftCertificateDao;
    private final TagDao tagDao;

    @Autowired
    public TagToGiftCertificateServiceImpl(TagToGiftCertificateDao tagToGiftCertificateDao,
                                           GiftCertificateDao giftCertificateDao,
                                           TagDao tagDao) {
        this.tagToGiftCertificateDao = tagToGiftCertificateDao;
        this.giftCertificateDao = giftCertificateDao;
        this.tagDao = tagDao;
    }

    @Transactional
    @Override
    public TagToGiftCertificateRelation createTagToGiftCertificateRelation(long tagId, long giftCertificateId) {
        Optional<Tag> optionalTag = tagDao.findById(tagId);
        if (!optionalTag.isPresent()) {
            throw new TagNotFoundException(String.format(TAG_NOT_FOUND_MSG, tagId));
        }

        Optional<GiftCertificate> optionalGiftCertificate = giftCertificateDao.findById(giftCertificateId);
        if (!optionalGiftCertificate.isPresent()) {
            throw new GiftCertificateNotFoundException(String.format(GIFT_CERTIFICATE_NOT_FOUND_MSG,
                    giftCertificateId));
        }

        return tagToGiftCertificateDao.createTagToGiftCertificateRelation(tagId, giftCertificateId);
    }

    @Override
    public List<GiftCertificate> findGiftCertificatesByTagName(String tagName) {
        List<GiftCertificate> giftCertificates = tagToGiftCertificateDao.findGiftCertificatesByTagName(tagName);
        if (giftCertificates.isEmpty()) {
            throw new GiftCertificatesNotFoundException(String.format(GIFT_CERTIFICATES_NOT_FOUND_MSG, tagName));
        }

        return tagToGiftCertificateDao.findGiftCertificatesByTagName(tagName);
    }
}
