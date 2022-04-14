package com.epam.esm.dao.impl;

import com.epam.esm.dao.TagToGiftCertificateDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.TagToGiftCertificateRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagToGiftCertificateDaoImpl implements TagToGiftCertificateDao {
    private static final String CREATE_TAG_TO_GIFT_CERTIFICATE_RELATION = "INSERT INTO tag_gift_certificate " +
            "(tag_id, gift_certificate_id) VALUES (?, ?)";
    private static final String GET_GIFT_CERTIFICATE_BY_TAG_NAME = "SELECT gift_certificate.id, " +
            "gift_certificate.name, description, price, duration, create_date, last_update_date FROM " +
            "gift_certificate JOIN tag_gift_certificate ON gift_certificate.id = " +
            "gift_certificate_id JOIN tag ON tag_id = tag.id WHERE tag.name = ?";
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<GiftCertificate> rowMapper;

    @Autowired
    public TagToGiftCertificateDaoImpl(JdbcTemplate jdbcTemplate, RowMapper<GiftCertificate> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public TagToGiftCertificateRelation createTagToGiftCertificateRelation(long tagId, long giftCertificateId) {
        jdbcTemplate.update(CREATE_TAG_TO_GIFT_CERTIFICATE_RELATION, tagId, giftCertificateId);
        TagToGiftCertificateRelation tagToGiftCertificate = new TagToGiftCertificateRelation();
        tagToGiftCertificate.setTagId(tagId);
        tagToGiftCertificate.setGiftCertificateId(giftCertificateId);
        return tagToGiftCertificate;
    }

    @Override
    public List<GiftCertificate> getGiftCertificateByTagName(String tagName) {
        return jdbcTemplate.query(GET_GIFT_CERTIFICATE_BY_TAG_NAME, rowMapper, tagName);
    }


}
