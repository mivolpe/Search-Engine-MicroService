package com.example.project.Service;

import com.example.project.Model.Catalog;
import com.example.project.Repository.CatalogRepository;
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
