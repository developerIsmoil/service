package com.terminal.controller;

import com.terminal.entity.Machine;
import com.terminal.model.filter.MachineFilterRequest;
import com.terminal.model.request.MachineRequest;
import com.terminal.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/machine")
public class MachineController {

    private final MachineService machineService;


    @GetMapping("/list")
    public ResponseEntity<Page<Machine>> list(MachineFilterRequest request){
        return ResponseEntity.ok(machineService.findByName(request));
    }

    @PostMapping("/save")
    public void save(@RequestBody MachineRequest machine){
        machineService.save(machine);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        machineService.delete(id);
    }

    @GetMapping("/list-by-category")
    public ResponseEntity<Page<Machine>> findAllByCategory(@RequestParam Long id,
                                                           @RequestParam MachineFilterRequest request){
        return ResponseEntity.ok(machineService.findByCategory(id, request));
    }


}
