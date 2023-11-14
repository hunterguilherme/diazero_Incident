package com.diazero.incidentAPI.modelmapper;

import com.diazero.incidentAPI.domain.model.Incident;
import com.diazero.incidentAPI.domain.model.dto.IncidentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityToOutputIncident {

	@Autowired
	private ModelMapper modelMapper;
	
	public IncidentDTO toModel(Incident incident) {
		return modelMapper.map(incident, IncidentDTO.class);
	}
	
	public List<IncidentDTO> toCollectionModel(List<Incident> incidentList) {
		return incidentList.stream()
				.map(incident -> toModel(incident))
				.collect(Collectors.toList());
	}
	
}
