package com.terminal.service.impl;

import com.terminal.entity.Category;
import com.terminal.exceptions.RequiredException;
import com.terminal.model.request.CategoryRequest;
import com.terminal.repository.CategoryRepository;
import com.terminal.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(CategoryRequest request) {
        Category category = request.getId() == null ? null :
                categoryRepository.findById(request.getId()).orElse(new Category());
        category.setName(request.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        if (id == null)
            throw new RequiredException("Id null");
            categoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> list(CategoryRequest request) {
        return categoryRepository.findAll((Pageable) request);
    }
}
