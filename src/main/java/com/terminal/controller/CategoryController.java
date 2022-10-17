package com.terminal.controller;

import com.terminal.entity.Category;
import com.terminal.model.request.CategoryRequest;
import com.terminal.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Page<Category>> list(CategoryRequest request) {
        return ResponseEntity.ok(categoryService.list(request));
    }

    @PostMapping("/save")
    public void save(@RequestBody CategoryRequest request) {
        categoryService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
