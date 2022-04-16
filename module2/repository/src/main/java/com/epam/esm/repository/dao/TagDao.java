package com.epam.esm.repository.dao;

import com.epam.esm.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagDao {
    Tag create(Tag entity);

    List<Tag> findAll();

    Optional<Tag> findById(long id);

    Optional<Tag> findByName(String name);

    boolean delete(long id);
}
