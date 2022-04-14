package com.epam.esm.controller;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.TagToGiftCertificateRelation;
import com.epam.esm.service.TagToGiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tag-to-gift-certificate")
public class TagToGiftCertificateController {
    private final TagToGiftCertificateService tagToGiftCertificateService;

    @Autowired
    public TagToGiftCertificateController(TagToGiftCertificateService tagToGiftCertificateService) {
        this.tagToGiftCertificateService = tagToGiftCertificateService;
    }

    @PostMapping
    public TagToGiftCertificateRelation createTagToGiftCertificateRelation(long giftCertificateId, long tagId) {
        return tagToGiftCertificateService.createTagToGiftCertificateRelation(giftCertificateId, tagId);
    }

    @GetMapping()
    public List<GiftCertificate> getGiftCertificateByTagName(String tagName) {
        return tagToGiftCertificateService.getGiftCertificateByTagName(tagName);
    }
}
