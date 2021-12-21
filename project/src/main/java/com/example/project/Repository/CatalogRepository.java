package com.example.project.Repository;

import com.example.project.Model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog,Long> {

    @Query(value = "SELECT * FROM catalog c WHERE c.title LIKE %?1% or c.artist LIKE %?1%", nativeQuery = true)
    public List<Catalog> search(String keyword);
}
