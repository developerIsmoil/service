package com.terminal.service;

import com.terminal.entity.Machine;
import com.terminal.model.filter.MachineFilterRequest;
import com.terminal.model.request.MachineRequest;
import org.springframework.data.domain.Page;

public interface MachineService extends AbstractService{
    Page<Machine> findByName(MachineFilterRequest request);

    Machine save(MachineRequest request);

    Page<Machine> findByCategory(Long id, MachineFilterRequest request);

    void delete(Long id);
}
