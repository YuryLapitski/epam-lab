package com.epam.esm.gift.dao.impl;

import com.epam.esm.gift.dao.TagDao;
import com.epam.esm.gift.entity.impl.Tag;

import java.util.List;
import java.util.Optional;

public class TagDaoImpl implements TagDao {
    @Override
    public Tag create(Tag entity) {
        return null;
    }

    @Override
    public List<Tag> findAll() {
        return null;
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
