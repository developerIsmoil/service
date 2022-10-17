package com.terminal.service.impl;

import com.terminal.entity.Machine;
import com.terminal.model.filter.MachineFilterRequest;
import com.terminal.model.request.MachineRequest;
import com.terminal.repository.MachineRepository;
import com.terminal.repository.OrganizationRepository;
import com.terminal.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MachineServiceImpl implements MachineService {
    private final MachineRepository machineRepository;
    private final OrganizationRepository organizationRepository;

    @Override
    public Page<Machine> findByName(MachineFilterRequest request) {
        return machineRepository.findBySerialNumberStartingWith(checkNull(request.getSerialNumber()),
                PageRequest.of(request.getPage(), request.getLimit()));
    }

    @Override
    public Machine save(MachineRequest request) {
        Machine machine = request.getId() == null
                ? null
                : machineRepository.findById(request.getId()).orElse(new Machine());

        machine.setSerialNumber(request.getSerialNumber());
        machine.setOrganization(request.getOrganizationId() == null ? null
                : organizationRepository.findById(request.getOrganizationId())
                .orElse(null));
        return machineRepository.save(machine);
    }

    @Override
    public Page<Machine> findByCategory(Long categoryId, MachineFilterRequest request) {
        return categoryId == null ?
                Page.empty() : machineRepository.findAllByCategory_id(categoryId,
                PageRequest.of(request.getPage(), request.getLimit()));
    }

    @Override
    public void delete(Long id) {
        if (id != null)
            machineRepository.deleteById(id);
    }
}