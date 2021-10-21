package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public List<Catalog> search(String keyword)
    {
        return catalogRepository.search(keyword);
    }
}
