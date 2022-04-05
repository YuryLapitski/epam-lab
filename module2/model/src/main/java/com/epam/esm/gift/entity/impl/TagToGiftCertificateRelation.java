package com.epam.esm.gift.entity.impl;

import com.epam.esm.gift.entity.Entity;

import java.util.Objects;

public class TagToGiftCertificateRelation implements Entity {
    private long id;
    private long tagId;
    private long giftCertificateId;

    public TagToGiftCertificateRelation(long id, long tagId, long giftCertificateId) {
        this.id = id;
        this.tagId = tagId;
        this.giftCertificateId = giftCertificateId;
    }

    //    public TagToGiftCertificateRelation(Long tagId, Long giftCertificateId) { todo Lombok
//        this(null, tagId,giftCertificateId);
//    }


    @Override
    public long getId() {
        return id;
    }

    public long getTagId() {
        return tagId;
    }

    public long getGiftCertificateId() {
        return giftCertificateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TagToGiftCertificateRelation that = (TagToGiftCertificateRelation) o;
        return id == that.id &&
                tagId == that.tagId &&
                giftCertificateId == that.giftCertificateId;
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
