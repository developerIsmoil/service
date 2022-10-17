package com.terminal.service;

import com.terminal.entity.ApplicationMachine;
import com.terminal.entity.enums.Status;
import com.terminal.model.filter.AppMachineFilterRequest;
import com.terminal.model.request.AppMachineRequest;
import org.springframework.data.domain.Page;

public interface AppMachineService {
    Page<ApplicationMachine> findByName(AppMachineFilterRequest request);

    ApplicationMachine save(AppMachineRequest request);

    void delete(Long id);

    Page<ApplicationMachine> findByRequest(AppMachineFilterRequest request, Status status);
}
