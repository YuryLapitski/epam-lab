package com.epam.esm.controller;

import com.epam.esm.entity.impl.GiftCertificate;
import com.epam.esm.exception.EntityNotFoundException;
import com.epam.esm.service.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gift-certificates")
public class GiftCertificateController {
    private final GiftCertificateService giftCertificateService;

    @Autowired
    public GiftCertificateController(GiftCertificateService giftCertificateService) {
        this.giftCertificateService = giftCertificateService;
    }

    @GetMapping("/{id}")
    public GiftCertificate findById(@PathVariable long id) throws EntityNotFoundException {
        return giftCertificateService.findById(id);
    }

    @PostMapping
    public GiftCertificate create(@RequestBody GiftCertificate giftCertificate) {
        return giftCertificateService.create(giftCertificate);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTag(@PathVariable long id) throws EntityNotFoundException {
        return giftCertificateService.delete(id);
    }

    @GetMapping("/")
    public List<GiftCertificate> findAll() {
        return giftCertificateService.findAll();
    }

    @PutMapping
    public GiftCertificate update(@RequestBody GiftCertificate giftCertificate) throws EntityNotFoundException {
        return giftCertificateService.update(giftCertificate);
    }
}
