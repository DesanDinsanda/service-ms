package com.example.ServiceManagement.tdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends
        JpaRepository<Category, Integer> {

    @Query("SELECT l from Category l where l.name=?1")
    public List<Category> searchCategory(String name);

}
