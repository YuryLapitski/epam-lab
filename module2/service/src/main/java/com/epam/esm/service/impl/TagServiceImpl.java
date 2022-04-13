package com.epam.esm.service.impl;

import com.epam.esm.dao.TagDao;
import com.epam.esm.entity.impl.Tag;
import com.epam.esm.exception.EntityNotFoundException;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {
    private static final String TAG_NOT_FOUND_MSG = "Tag with id=%d not found.";
    private final TagDao tagDao;

    @Autowired
    public TagServiceImpl(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public Tag create(Tag tag) {
        return tagDao.create(tag);
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    @Override
    public Tag findById(long id) throws EntityNotFoundException {
        return tagDao.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format(TAG_NOT_FOUND_MSG, id)));
    }

    @Override
    public boolean delete(long id) throws EntityNotFoundException {
        Optional<Tag> optionalTag = tagDao.findById(id);
        if (optionalTag.isPresent()) {
            return tagDao.delete(id);
        } else {
            throw new EntityNotFoundException(String.format(TAG_NOT_FOUND_MSG, id));
        }

    }
}
