package com.epam.esm.controller;

import com.epam.esm.entity.impl.Tag;
import com.epam.esm.exception.EntityNotFoundException;
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
    public Tag findById(@PathVariable long id) throws EntityNotFoundException {
        System.out.println("Hello GET" + id);
        return tagService.findById(id);
    }

    @PostMapping
    public Tag create(@RequestBody Tag tag) {
        System.out.println("Hello POST");
        return tagService.create(tag);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTag(@PathVariable Long id) {
        return tagService.delete(id);
    }

    @GetMapping("/allTags")
    public List<Tag> findAll() {
        return tagService.findAll();
    }
}
