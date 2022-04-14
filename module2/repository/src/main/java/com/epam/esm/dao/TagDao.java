package com.epam.esm.dao;

import com.epam.esm.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagDao {
    Tag create(Tag entity);

    List<Tag> findAll();

    Optional<Tag> findById(long id);

    boolean delete(long id);

    boolean deleteTagByName(String name);

}
