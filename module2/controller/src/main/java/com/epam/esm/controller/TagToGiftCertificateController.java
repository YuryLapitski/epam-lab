package com.epam.esm.controller;

import com.epam.esm.entity.TagToGiftCertificateRelation;
import com.epam.esm.service.TagToGiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tag-to-gift-certificates")
public class TagToGiftCertificateController {
    private final TagToGiftCertificateService tagToGiftCertificateService;

    @Autowired
    public TagToGiftCertificateController(TagToGiftCertificateService tagToGiftCertificateService) {
        this.tagToGiftCertificateService = tagToGiftCertificateService;
    }

    @PostMapping
    public TagToGiftCertificateRelation createTagToGiftCertificateRelation(
            @RequestBody TagToGiftCertificateRelation tagToGiftCertificateRelation) {
        return tagToGiftCertificateService.createTagToGiftCertificateRelation(
                tagToGiftCertificateRelation.getTagId(),
                tagToGiftCertificateRelation.getGiftCertificateId());
    }
}
