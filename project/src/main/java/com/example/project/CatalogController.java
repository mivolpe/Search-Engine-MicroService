package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/search/{keyword}")
    public List<Catalog> search( @PathVariable String keyword)
    {
        return catalogService.search(keyword);

    }
}
