package com.epam.esm.controller;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.service.GiftCertificateService;
import com.epam.esm.service.TagToGiftCertificateService;
import com.epam.esm.service.dto.GiftCertificateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gift-certificates")
public class GiftCertificateController {
    private final GiftCertificateService giftCertificateService;
    private final TagToGiftCertificateService tagToGiftCertificateService;

    @Autowired
    public GiftCertificateController(GiftCertificateService giftCertificateService,
                                     TagToGiftCertificateService tagToGiftCertificateService) {
        this.giftCertificateService = giftCertificateService;
        this.tagToGiftCertificateService = tagToGiftCertificateService;
    }

    @GetMapping("/{id}")
    public GiftCertificateDto findById(@PathVariable long id) {
        return giftCertificateService.findByGiftCertificateId(id);
    }

    @GetMapping("/name")
    public List<GiftCertificateDto> findByName(@RequestParam(name = "name") String name) {
        return giftCertificateService.findByPartOfName(name);
    }

    @PostMapping
    public GiftCertificateDto create(@RequestBody GiftCertificateDto giftCertificateDto) {
        return giftCertificateService.create(giftCertificateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGiftCertificate(@PathVariable long id) {
        giftCertificateService.delete(id);
    }

    @GetMapping
    public List<GiftCertificateDto> findAll() {
        return giftCertificateService.findAll();
    }

    @PutMapping("/{id}")
    public GiftCertificateDto update(@PathVariable long id, @RequestBody GiftCertificate giftCertificate) {
        giftCertificate.setId(id);
        return giftCertificateService.update(giftCertificate);
    }

    @GetMapping("/sort")
    public List<GiftCertificateDto> findAllWithSort(@RequestParam(name = "columnName") String columnName,
                                                 @RequestParam(name = "sortType") String sortType) {
        return giftCertificateService.findAllWithSort(columnName, sortType);
    }

    @GetMapping("/by-tag")
    public List<GiftCertificateDto> findGiftCertificatesByTagName(@RequestParam(name = "tagName") String tagName) {
        return tagToGiftCertificateService.findGiftCertificatesByTagName(tagName);
    }
}
