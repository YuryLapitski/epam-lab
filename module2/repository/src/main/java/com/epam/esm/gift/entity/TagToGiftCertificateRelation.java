package com.epam.esm.gift.entity;

import java.util.Objects;

public class TagToGiftCertificateRelation implements Entity {

    private static final long serialVersionUID = -1140545585762920279L;
    private final Long id;
    private final Long tagId;
    private final Long giftCertificateId;

    public TagToGiftCertificateRelation(Long id, Long tagId, Long giftCertificateId) {
        this.id = id;
        this.tagId = tagId;
        this.giftCertificateId = giftCertificateId;
    }

    public TagToGiftCertificateRelation(Long tagId, Long giftCertificateId) {
        this(null, tagId,giftCertificateId);
    }

    @Override
    public Long getId() {
        return id;
    }

    public Long getTagId() {
        return tagId;
    }

    public Long getGiftCertificateId() {
        return giftCertificateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagToGiftCertificateRelation that = (TagToGiftCertificateRelation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tagId, that.tagId) &&
                Objects.equals(giftCertificateId, that.giftCertificateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagId, giftCertificateId);
    }

    @Override
    public String toString() {
        return "TagToGiftCertificateRelation{" +
                "id=" + id +
                ", tagId=" + tagId +
                ", giftCertificateId=" + giftCertificateId +
                '}';
    }
}
