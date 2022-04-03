package com.epam.esm.gift.entity;

import java.util.Objects;

public class Tag implements Entity {

    private static final long serialVersionUID = -1052515469061625999L;
    private final Long id;
    private final String name;

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tag(String name) {
        this(null, name);
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) &&
                Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
