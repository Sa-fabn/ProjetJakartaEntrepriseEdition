package org.efrei.demo.repositories;

import org.efrei.demo.models.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends JpaRepository<Award, String> {
}

