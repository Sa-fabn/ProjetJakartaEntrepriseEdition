package org.efrei.demo.controllers;

import java.util.List;

import org.efrei.demo.models.Award;
import org.efrei.demo.services.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/awards")
public class AwardController {

    private final AwardService service;

    @Autowired
    public AwardController(AwardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Award>> findAll() {
        return new ResponseEntity<>(service.getAllAwards(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Award> findById(@PathVariable String id) {
        Award award = service.getAwardById(id).orElse(null);
        if (award == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(award, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Award award) {
        service.createAward(award);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        Award award = service.getAwardById(id).orElse(null);
        if (award == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteAward(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Award award) {
        service.updateAward(id, award);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
