package com.diazero.incidentAPI.domain.serviceImpl;

import com.diazero.incidentAPI.domain.exceptions.EntityNotFoundException;
import com.diazero.incidentAPI.domain.model.Incident;
import com.diazero.incidentAPI.domain.model.dto.IncidentDTO;
import com.diazero.incidentAPI.domain.model.dto.IncidentInputDTO;
import com.diazero.incidentAPI.domain.repository.IncidentRepository;
import com.diazero.incidentAPI.domain.service.IncidentService;
import com.diazero.incidentAPI.modelmapper.InputToEntityIncident;
import com.diazero.incidentAPI.modelmapper.EntityToOutputIncident;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class IncidentServiceImpl implements IncidentService {
    private static final String NOT_FOUND = "Incident not found";

    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private EntityToOutputIncident entityToOutputIncident;

    @Autowired
    private InputToEntityIncident inputToEntityIncident;

    @Override
    @Transactional
    public IncidentDTO createIncident(IncidentInputDTO incidentInputDTO) {

        Incident incident = inputToEntityIncident.toDomainObject(incidentInputDTO);

        incident.setCreatedAt(OffsetDateTime.now());
        incident.setUpdatedAt(OffsetDateTime.now());

        incident = incidentRepository.save(incident);
        IncidentDTO incidentOutputDTO = entityToOutputIncident.toModel(incident);
        return incidentOutputDTO;
    }

    @Override
    public IncidentDTO updateIncident(Long id, IncidentInputDTO updatedIncident) {

        Incident currentIncident = searchOrFail(id);

        BeanUtils.copyProperties(updatedIncident, currentIncident, "id", "createdAt");
        currentIncident.setUpdatedAt(OffsetDateTime.now());
        incidentRepository.save(currentIncident);
        IncidentDTO incidentOutputDTO = entityToOutputIncident.toModel(currentIncident);

        return incidentOutputDTO;
    }

    @Override
    public void removeIncident(IncidentDTO incidentDTO) {

    }

    @Override
    public List<IncidentDTO> getAllIncident(IncidentDTO incidentDTO) {
        return null;
    }

    @Override
    public List<IncidentDTO> getIncidentById(Long id) {
        return null;
    }

    @Override
    public List<IncidentDTO> getLastTwentyIncidents(IncidentDTO incidentDTO) {
        return null;
    }

    public Incident searchOrFail(Long id) {
        return incidentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND));
    }
}
