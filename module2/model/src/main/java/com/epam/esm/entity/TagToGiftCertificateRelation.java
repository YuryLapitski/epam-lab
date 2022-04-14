package com.epam.esm.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class TagToGiftCertificateRelation {
    private long tagId;
    private long giftCertificateId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TagToGiftCertificateRelation that = (TagToGiftCertificateRelation) o;

        return tagId == that.tagId &&
                giftCertificateId == that.giftCertificateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, giftCertificateId);
    }
}
