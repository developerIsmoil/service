package com.terminal.service.impl;

import com.terminal.entity.Models;
import com.terminal.model.request.ModelsRequest;
import com.terminal.repository.ModelsRepository;
import com.terminal.service.ModelsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelsServiceImpl implements ModelsService {
    private final ModelsRepository modelsRepository;
    @Override
    public Page<Models> list(ModelsRequest request){
        return modelsRepository.findAll((Pageable) request);
    }

    @Override
    public Models save(ModelsRequest request) {
        return null;
    }
    @Override
    public void delete(Long id){
        modelsRepository.deleteById(id);
    }

}
