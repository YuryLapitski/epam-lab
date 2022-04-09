package com.epam.esm.dao;

import com.epam.esm.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface EntityDao<T extends Entity> {

    T create(T entity);

    List<T> findAll();

    Optional<T> findById(long id);

    boolean delete(long id);
}
