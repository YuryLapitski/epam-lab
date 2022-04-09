package com.epam.esm.dao;

import com.epam.esm.entity.impl.Tag;

public interface TagDao extends EntityDao<Tag> {

    boolean deleteTagByName(String name);

}
