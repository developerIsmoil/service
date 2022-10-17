package com.terminal.service;

import com.terminal.entity.Category;
import com.terminal.model.request.CategoryRequest;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Category save(CategoryRequest categoryRequest);

    void delete(Long id);

    Page<Category> list(CategoryRequest request);
}
