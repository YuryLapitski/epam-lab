package com.epam.esm.service;

import com.epam.esm.entity.Tag;
import java.util.List;

public interface TagService {
    Tag create(Tag tag);

    List<Tag> findAll();

    Tag findById(long id);

    boolean delete(long id);
}
