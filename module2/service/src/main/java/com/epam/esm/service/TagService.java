package com.epam.esm.service;

import com.epam.esm.entity.impl.Tag;
import com.epam.esm.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Tag create(Tag tag);

    List<Tag> findAll();

    Tag findById(long id) throws EntityNotFoundException;

    boolean delete(long id);
}
