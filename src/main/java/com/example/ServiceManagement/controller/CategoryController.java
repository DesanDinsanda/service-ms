package com.example.ServiceManagement.controller;

import com.example.ServiceManagement.data.Category;
import com.example.ServiceManagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:5173")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllLecture() {
        return categoryService.getAllCategories();
    }
    @GetMapping(path = "/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }
    @PostMapping
    public Category crateCategory(@RequestBody Category s){
        return categoryService.createCategory(s);
    }
    @PutMapping
    public Category updateCategory(@RequestBody Category s) {
        return categoryService.updateCategory(s);
    }

    @GetMapping(params ={"name"})
    public List<Category> searchCategory(@RequestParam String name) {
        return categoryService.searchCategory(name);
    }

    @RequestMapping(method = RequestMethod.HEAD, path = "/{id}")
    public ResponseEntity<Void> serviceExistsById(@PathVariable int id){
        if (categoryService.serviceExistsById(id)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
