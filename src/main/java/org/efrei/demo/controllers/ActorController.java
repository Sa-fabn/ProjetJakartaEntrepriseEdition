package org.efrei.demo.controllers;
import java.util.List;

import org.efrei.demo.models.Actor;
import org.efrei.demo.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService service;
    @Autowired
    public ActorController(ActorService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Actor>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findById(@PathVariable String id){
        Actor actor = service.findById(id);
        if (actor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<> (service.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Actor actor){
        service.create(actor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?> deleteById(@PathVariable String id){
        Actor actor = service.findById(id);
        if (actor==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Actor actor) {
        service.update(id, actor);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}