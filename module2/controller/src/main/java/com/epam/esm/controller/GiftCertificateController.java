package com.epam.esm.controller;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.service.GiftCertificateService;
import com.epam.esm.service.dto.GiftCertificateDto;
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

    @GetMapping("/id/{id}")
    public GiftCertificate findById(@PathVariable long id) {
        return giftCertificateService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<GiftCertificate> findByName(@PathVariable String name) {
        return giftCertificateService.findByPartOfName(name);
    }

    @PostMapping
    public GiftCertificateDto create(@RequestBody GiftCertificateDto giftCertificateDto) {
        return giftCertificateService.create(giftCertificateDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteGiftCertificate(@PathVariable long id) {
        return giftCertificateService.delete(id);
    }

    @GetMapping
    public List<GiftCertificate> findAll() {
        return giftCertificateService.findAll();
    }

    @PutMapping("/{id}")
    public GiftCertificate update(@PathVariable long id, @RequestBody GiftCertificate giftCertificate) {
        giftCertificate.setId(id);
        return giftCertificateService.update(giftCertificate);
    }
}
