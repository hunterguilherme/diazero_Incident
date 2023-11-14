package com.diazero.incidentAPI.modelmapper;

import com.diazero.incidentAPI.domain.model.Incident;
import com.diazero.incidentAPI.domain.model.dto.IncidentInputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InputToEntityIncident {

	@Autowired
	private ModelMapper modelMapper;
	
	public Incident toDomainObject(IncidentInputDTO incidentInputDTO) {
		return modelMapper.map(incidentInputDTO, Incident.class);
	}
	
	public void copyToDomainObject(IncidentInputDTO incidentInputDTO, Incident incident) {
		modelMapper.map(incidentInputDTO, incident);
	}
	
}
