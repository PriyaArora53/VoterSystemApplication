package com.learning.votingsystem.repositories;

import com.learning.votingsystem.entity.Candidates;
import com.learning.votingsystem.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepo extends JpaRepository<Candidates, Integer> {
}