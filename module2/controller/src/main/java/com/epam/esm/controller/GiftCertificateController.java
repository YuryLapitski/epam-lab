package com.epam.esm.controller;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.service.GiftCertificateService;
import com.epam.esm.service.dto.GiftCertificateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody (required = false) GiftCertificateDto giftCertificateDto,
                       @RequestParam (required = false, name = "tagId") Long tagId,
                       @RequestParam (required = false, name = "giftCertificateId") Long giftCertificateId) {
        giftCertificateService.createByParam(giftCertificateDto, tagId, giftCertificateId);
    }

    @PutMapping("/{id}")
    public GiftCertificateDto update(@PathVariable long id, @RequestBody GiftCertificate giftCertificate) {
        giftCertificate.setId(id);
        return giftCertificateService.update(giftCertificate);
    }

    @GetMapping
    public List<GiftCertificateDto> findByAttributes(
            @RequestParam(required = false, name = "id") Long id,
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "tagName") String tagName,
            @RequestParam(required = false, name = "columnName") String columnName,
            @RequestParam(required = false, name = "sortType") String sortType) {
        return giftCertificateService.findByAttributes(id, name, tagName, columnName, sortType);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGiftCertificate(@PathVariable long id) {
        giftCertificateService.delete(id);
    }
}
