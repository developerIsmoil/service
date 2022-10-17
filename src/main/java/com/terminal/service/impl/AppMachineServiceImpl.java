package com.terminal.service.impl;

import com.terminal.entity.ApplicationMachine;
import com.terminal.entity.Machine;
import com.terminal.entity.enums.Status;
import com.terminal.exceptions.RequiredException;
import com.terminal.model.filter.AppMachineFilterRequest;
import com.terminal.model.request.AppMachineRequest;
import com.terminal.repository.AppMachineRepository;
import com.terminal.repository.ApplicationRepository;
import com.terminal.repository.MachineRepository;
import com.terminal.service.AppMachineService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppMachineServiceImpl implements AppMachineService {
    @Autowired
    private AppMachineRepository appMachineRepository;
    @Autowired
    private ApplicationRepository applicationRepasitory;
    @Autowired
    private MachineRepository machineRepository;


    @Override
    public Page<ApplicationMachine> findByName(AppMachineFilterRequest request) {
        return appMachineRepository.findByMachine_SerialNumberStartingWith(request.getName(), PageRequest.of(request.getPage(), request.getLimit()));
    }

    @Override
    public ApplicationMachine save(AppMachineRequest request) {
        ApplicationMachine applicationMachine = request.getId() == null ? null :
                appMachineRepository.findById(request.getId())
                        .orElse(new ApplicationMachine());
        applicationMachine.setApplication(applicationRepasitory.findById(request.getApplicationId())
                .orElse(null));
        Machine machine = request.getId() == null ? null :
                machineRepository.findById(request.getMachineId()).orElse(null);
        if (machine == null)
            throw new RequiredException("");
        applicationMachine.setMachine(machine);
        applicationMachine.setCategory(machine.getCategory());
        return appMachineRepository.save(applicationMachine);
    }

    @Override
    public void delete(Long id) {
        if (id != null)
            appMachineRepository.deleteById(id);
    }

    @Override
    public Page<ApplicationMachine> findByRequest(AppMachineFilterRequest request, Status status) {
        if (ObjectUtils.isEmpty(request.getName()))
            request.setName("");
        return appMachineRepository.findByStatusAndMachine_SerialNumberStartsWith(
                status, request.getName(), PageRequest.of(request.getPage(), request.getLimit()));
    }
}
