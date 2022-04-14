package com.epam.esm.service;

import com.epam.esm.entity.Tag;
import com.epam.esm.exception.TagNotFoundException;

import java.util.List;

public interface TagService {
    Tag create(Tag tag);

    List<Tag> findAll();

    Tag findById(long id) throws TagNotFoundException;

    boolean delete(long id) throws TagNotFoundException;
}
