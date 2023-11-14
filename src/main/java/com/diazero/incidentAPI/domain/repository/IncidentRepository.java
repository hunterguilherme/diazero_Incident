package com.diazero.incidentAPI.domain.repository;


import com.diazero.incidentAPI.domain.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findTop20ByOrderByCreatedAtDesc();

}
