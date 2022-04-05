package com.epam.esm.gift.dao;

import com.epam.esm.gift.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface EntityDao<T extends Entity> {

    T create(T entity);

    List<T> findAll(); //todo findAll

    Optional<T> findById(Long id); //todo findById

    boolean delete(Long id);
}
