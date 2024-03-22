package com.rpietraszewski.medicalclinicproxy.controller;

import com.rpietraszewski.medicalclinicproxy.model.dto.AssignVisitCommandDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.VisitDTO;
import com.rpietraszewski.medicalclinicproxy.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visits")
@RequiredArgsConstructor
public class VisitController {
    private final VisitService visitService;

    @PostMapping
    VisitDTO createAssignedVisit(@RequestBody AssignVisitCommandDTO assignVisitCommandDTO){
        return visitService.createAssignedVisit(assignVisitCommandDTO);
    }
}
