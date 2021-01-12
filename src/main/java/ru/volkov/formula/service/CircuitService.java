package ru.volkov.formula.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.volkov.formula.api.CircuitApi;
import ru.volkov.formula.entity.CircuitEntity;
import ru.volkov.formula.model.Circuit;
import ru.volkov.formula.model.CircuitTable;
import ru.volkov.formula.model.CircuitsResponse;
import ru.volkov.formula.model.MRData;
import ru.volkov.formula.repository.CircuitRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CircuitService {
    private static final Logger LOG = LoggerFactory.getLogger(CircuitService.class);

    private final CircuitRepository repository;
    private final CircuitApi circuitApi;

    @Autowired
    public CircuitService(
            CircuitRepository repository,
            CircuitApi circuitApi) {
        this.repository = repository;
        this.circuitApi = circuitApi;
    }

    public CircuitsResponse saveAllCircuits(){
        ResponseEntity<CircuitsResponse> response = circuitApi.getAllCircuits();
        List<Circuit> circuitsDto = getCircuitDTOList(response);
        List<CircuitEntity> circuitEntityList = makeListCircuitEntity(circuitsDto);
        saveCircuitEntityList(circuitEntityList);
        return response.getBody();
    }

    public List<Circuit> getCircuitDTOList(ResponseEntity<CircuitsResponse> response){
        LOG.debug("Start to get circuit DTO list from HTTP response");
        MRData mrData = response.getBody().getMrData();
        CircuitTable circuitTable = mrData.getCircuitTable();
        List<Circuit> circuits = circuitTable.getCircuits();
        LOG.debug("Circuit DTO list was created with {} elements", circuits.size());
        return circuits;
    }

    public void saveCircuitEntityList(List<CircuitEntity> circuitEntityList){
        LOG.debug("Start to save Circuit entity list to database");
        repository.saveAll(circuitEntityList);
        LOG.debug("Circuit entity list was successfully saved");
    }

    public List<CircuitEntity> makeListCircuitEntity(List<Circuit> circuitList){
        LOG.debug("Start to convert Circuit DTO list to Circuit entity list");
        List<CircuitEntity> circuitEntityList = circuitList.stream()
                .map(this::convertToEntityFrom)
                .collect(Collectors.toList());
        LOG.debug("Circuit entity list was created with {} elements", circuitEntityList.size());
        return circuitEntityList;
    }

    public CircuitEntity convertToEntityFrom(Circuit circuit) {
        CircuitEntity circuitEntity = new CircuitEntity();
        circuitEntity.setCircuitId(circuit.getCircuitId());
        circuitEntity.setUrl(circuit.getUrl());
        circuitEntity.setCircuitName(circuit.getCircuitName());
        circuitEntity.setLongitude(circuit.getLocation().getLong());
        circuitEntity.setLatitude(circuit.getLocation().getLat());
        circuitEntity.setLocality(circuit.getLocation().getLocality());
        circuitEntity.setCountry(circuit.getLocation().getCountry());
        circuitEntity.setModifiedDate(LocalDateTime.now());
        return circuitEntity;
    }


}
