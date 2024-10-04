package org.efrei.demo.services;

import org.efrei.demo.models.Category;
import org.efrei.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public void create(Category category) {
        repository.save(category);
    }

    public Category findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Category category) {
        category.setId(id);
        repository.save(category);
    }
}

