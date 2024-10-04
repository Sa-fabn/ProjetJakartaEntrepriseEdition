package org.efrei.demo.services;

import org.efrei.demo.models.Award;
import org.efrei.demo.repositories.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AwardService {

    private final AwardRepository awardRepository;

    @Autowired
    public AwardService(AwardRepository awardRepository) {
        this.awardRepository = awardRepository;
    }



    public Award createAward(Award award) {
        return awardRepository.save(award);
    }


    public List<Award> getAllAwards() {
        return awardRepository.findAll();
    }


    public Optional<Award> getAwardById(String id) {
        return awardRepository.findById(id);
    }

    public Award updateAward(String id, Award award) {
        award.setId(id);
        return awardRepository.save(award);
    }


    public void deleteAward(String id) {
        awardRepository.deleteById(id);
    }
}

