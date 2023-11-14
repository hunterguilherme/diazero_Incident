package com.diazero.incidentAPI.controller;


import com.diazero.incidentAPI.domain.model.Incident;
import com.diazero.incidentAPI.domain.model.dto.IncidentDTO;
import com.diazero.incidentAPI.domain.model.dto.IncidentInputDTO;
import com.diazero.incidentAPI.domain.serviceImpl.IncidentServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@Authorize
@RestController
@RequestMapping(value = "/diazero")
public class IncidentController {
    @Autowired
    private IncidentServiceImpl incidentService;
    @ApiOperation(value = "incident Creation", nickname = "createIncident", notes = "Saves an incident", response = IncidentDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Incident Creation Success"),
            @ApiResponse(code = 400, message = "Incident not found")})
    @RequestMapping(consumes = { "application/json" }, produces = { "application/json" }, method = RequestMethod.POST)
    public ResponseEntity<IncidentDTO> createIncident(@RequestBody @Valid IncidentInputDTO incidentInputDTO) {
        IncidentDTO incident = incidentService.createIncident(incidentInputDTO);
        return ResponseEntity.ok(incident);
    }

    @ApiOperation(value = "incident Update", nickname = "updateIncident", notes = "Updates an Incident", response = IncidentDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Incident Updated Successfully"),
            @ApiResponse(code = 400, message = "Incident not found")})
    @RequestMapping(value = "{id}", consumes = { "application/json" }, produces = { "application/json" }, method = RequestMethod.PUT)
    public ResponseEntity<IncidentDTO> updateIncident(@PathVariable Long id, @RequestBody @Valid IncidentInputDTO incidentInputDTO) {
        IncidentDTO incident = incidentService.updateIncident(id, incidentInputDTO);
        return ResponseEntity.ok(incident);
    }


    @ApiOperation(value = "incident by Id", nickname = "getIncidentById", notes = "get an incident by its id", response = IncidentDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Incident exists"),
            @ApiResponse(code = 400, message = "Incident not found")})
    @RequestMapping(value = "{id}", consumes = { "application/json" }, produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<IncidentDTO> getIncidentById(@PathVariable Long id) {
        IncidentDTO incident = incidentService.getIncidentById(id);
        return ResponseEntity.ok(incident);
    }

    @ApiOperation(value = "incident by Id", nickname = "getIncidentById", notes = "get an incident by its id", response = IncidentDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Incident exists"),
            @ApiResponse(code = 400, message = "Incident not found")})
    @RequestMapping( consumes = { "application/json" }, produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<IncidentDTO>> getAllIncidents() {
        List<IncidentDTO> incident = incidentService.getAllIncidents();
        return ResponseEntity.ok(incident);
    }
}
