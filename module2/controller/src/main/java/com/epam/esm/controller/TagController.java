package com.epam.esm.controller;

import com.epam.esm.entity.Tag;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tags")
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/{id}")
    public Tag findById(@PathVariable long id) {
        return tagService.findById(id);
    }

    @PostMapping
    public Tag create(@RequestBody Tag tag) {
        return tagService.create(tag);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTag(@PathVariable long id) {
        return tagService.delete(id);
    }

    @GetMapping
    public List<Tag> findAll() {
        return tagService.findAll();
    }
}
