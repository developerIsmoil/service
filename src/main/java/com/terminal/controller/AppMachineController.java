package com.terminal.controller;

import com.terminal.entity.ApplicationMachine;
import com.terminal.entity.enums.Status;
import com.terminal.model.filter.AppMachineFilterRequest;
import com.terminal.model.request.AppMachineRequest;
import com.terminal.service.AppMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/appmachine")
public class AppMachineController {
    @Autowired
    private AppMachineService appMachineService;

    @GetMapping("/list")
    public ResponseEntity<Page<ApplicationMachine>> list(AppMachineFilterRequest request) {
        return ResponseEntity.ok(appMachineService.findByName(request));
    }

    @GetMapping("/find-new")
    public ResponseEntity<Page<ApplicationMachine>> findNew(AppMachineFilterRequest request) {
        return ResponseEntity.ok(appMachineService.findByRequest(request, Status.NEW));
    }

    @GetMapping("/find-accepted")
    public ResponseEntity<Page<ApplicationMachine>> findAccepted(AppMachineFilterRequest request) {
        return ResponseEntity.ok(appMachineService.findByRequest(request, Status.ACCEPT));
    }

    @GetMapping("/find-inprogress")
    public ResponseEntity<Page<ApplicationMachine>> findProgress(AppMachineFilterRequest request) {
        return ResponseEntity.ok(appMachineService.findByRequest(request, Status.INPROGRESS));
    }

    @GetMapping("/find-repaired")
    public ResponseEntity<Page<ApplicationMachine>> findRepaired(AppMachineFilterRequest request) {
        return ResponseEntity.ok(appMachineService.findByRequest(request, Status.REPAIRED));
    }

    @GetMapping("/find-invalid")
    public ResponseEntity<Page<ApplicationMachine>> findValid(AppMachineFilterRequest request) {
        return ResponseEntity.ok(appMachineService.findByRequest(request, Status.INVALID));
    }

    @GetMapping("/find-finished")
    public ResponseEntity<Page<ApplicationMachine>> findFinish(AppMachineFilterRequest request) {
        return ResponseEntity.ok(appMachineService.findByRequest(request, Status.FINISHED));
    }

    @PostMapping("/save")
    public void save(@RequestBody AppMachineRequest appMachineRequest) {
        appMachineService.save(appMachineRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appMachineService.delete(id);
    }
}
