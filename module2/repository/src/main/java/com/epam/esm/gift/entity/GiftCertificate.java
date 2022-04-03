package com.epam.esm.gift.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class GiftCertificate implements Entity {

    private static final long serialVersionUID = -8328450787125096711L;
    private final Long id;
    private final String name;
    private final String description;
    private final Double price;
    private final Byte duration;
    private final LocalDateTime createDate;
    private final LocalDateTime lastUpdateDate;

    public GiftCertificate(Long id, String name, String description, Double price, Byte duration,
                           LocalDateTime createDate, LocalDateTime lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public GiftCertificate(String name, String description, Double price, Byte duration,
                           LocalDateTime createDate, LocalDateTime lastUpdateDate) {
        this(null, name, description, price, duration, createDate, lastUpdateDate);
    }

    @Override
    public Long getId() {
        return null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Byte getDuration() {
        return duration;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftCertificate that = (GiftCertificate) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, duration, createDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        return "GiftCertificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
