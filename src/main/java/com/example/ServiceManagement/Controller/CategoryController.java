package com.example.ServiceManagement.Controller;

import com.example.ServiceManagement.data.Category;
import com.example.ServiceManagement.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")

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
}
