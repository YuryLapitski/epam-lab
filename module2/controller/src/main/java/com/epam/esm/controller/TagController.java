package com.epam.esm.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tags")
public class TagController {
    @GetMapping("/{id}")
    public void findById(@PathVariable long id) {
        System.out.println("Hello GET" + id);
    }

    @PostMapping()
    public void findById2() {
        System.out.println("Hello POST");
    }
}
