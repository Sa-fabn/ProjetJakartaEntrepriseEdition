package org.efrei.demo.services;

import org.efrei.demo.models.Actor;
import org.efrei.demo.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository repository;
    @Autowired
    public ActorService(ActorRepository repository){
        this.repository = repository;
    }
    public List<Actor> findAll(){
        return repository.findAll();
    }
    public void create(Actor actor){
        repository.save(actor);
    }

    public Actor findById(String id){
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id){
        repository.deleteById(id);

    }

    public void update(String id, Actor actor){
        Actor updatedActor = findById(id);
        updatedActor.setName(actor.getName());
        updatedActor.setFirstname(actor.getFirstname());
        repository.save(updatedActor);
    }


}

