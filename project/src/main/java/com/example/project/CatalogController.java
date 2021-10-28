package com.example.project;

import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
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

    @GetMapping(value ="/searching/{keyword}")
    public List<Catalog> getCatalogKeyword (@PathVariable String keyword){
        String url = "http://localhost:8000/search/a";
        RestTemplate restTemplate = new RestTemplate();
        Catalog[] catalog = restTemplate.getForObject(url, Catalog[].class);

        ArrayList<Catalog> searchCatalog = new ArrayList<Catalog>();
        for(int i = 0; i < catalog.length; i++){
            if (catalog[i].getTitle().indexOf(keyword) != -1 || catalog[i].getArtist().indexOf(keyword) != -1 ){

                searchCatalog.add(catalog[i]);
            }
        }
        return searchCatalog;
    }
}
