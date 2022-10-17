package com.terminal.controller;

import com.terminal.entity.Models;
import com.terminal.model.request.ModelsRequest;
import com.terminal.service.ModelsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/models")
@RequiredArgsConstructor
public class ModelsController {
    private final ModelsService modelsService;

    @GetMapping("/list")
    public ResponseEntity<Page<Models>> list(ModelsRequest request) {
        return ResponseEntity.ok(modelsService.list(request));

    }

    @PostMapping("/save")
    public void save(@RequestBody ModelsRequest models) {
        modelsService.save(models);
    }


    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        modelsService.delete(id);
    }
}