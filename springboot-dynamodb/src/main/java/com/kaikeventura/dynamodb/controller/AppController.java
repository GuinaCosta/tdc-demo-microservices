package com.kaikeventura.dynamodb.controller;

import com.kaikeventura.dynamodb.dto.MeetupChavesDTO;
import com.kaikeventura.dynamodb.model.MeetupChaves;
import com.kaikeventura.dynamodb.service.MeetupService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class AppController {

    private final MeetupService meetupService;

    public AppController(MeetupService meetupService) {
        this.meetupService = meetupService;
    }

    @PostMapping("costumer")
    public ResponseEntity<MeetupChaves> newCostumer(@Valid @RequestBody MeetupChavesDTO costumerDTO) {
        return new ResponseEntity(meetupService.saveItem(costumerDTO), HttpStatus.OK);
    }

    @GetMapping("costumer")
    public ResponseEntity<List<MeetupChaves>> findCostumerByName(@Param("companyName") String companyName) {
        return ResponseEntity.ok(meetupService.findByName(companyName));
    }

    @GetMapping("costumer/all")
    public ResponseEntity<List<MeetupChaves>> allCostumers() {
        return ResponseEntity.ok(meetupService.findAllItems());
    }

    @PutMapping("costumer/{companyDocumentNumber}")
    public ResponseEntity<MeetupChaves> updateCostumer(
            @PathVariable("companyDocumentNumber") Integer id,
            @Valid @RequestBody MeetupChavesDTO meetupChavesDTO
    ) {
        return ResponseEntity.ok(meetupService.updateItem(id, meetupChavesDTO));
    }

}
