package com.example.ServiceManagement.tinterservice;

import com.example.ServiceManagement.tinterservice.interservice.WorkerService;
import com.example.ServiceManagement.tdata.Category;
import com.example.ServiceManagement.tdata.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private WorkerService workerService;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category getCategoryById(int id){
        Optional<Category> s =
                categoryRepository.findById(id);
        if(s.isPresent()){
            return s.get();
        }
        return null;
    }
    public Category createCategory(Category s){
        return categoryRepository.save(s);
    }

    public Category updateCategory(Category s) {
        return categoryRepository.save(s);
    }

    public List<Category> searchCategory(String name){
        return categoryRepository.searchCategory(name);
    }

    public Boolean serviceExistsById(int id){
        return categoryRepository.existsById(id);
    }

    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
        workerService.deleteSkillsByDeletedServiceId(id);
    }

}
