package com.terminal.service;

import com.terminal.entity.Models;
import com.terminal.model.request.ModelsRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ModelsService {
Page<Models> list (ModelsRequest request);
Models save(ModelsRequest request);
 void delete(Long id);
}
