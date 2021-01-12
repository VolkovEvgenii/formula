package ru.volkov.formula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.volkov.formula.api.CircuitApi;
import ru.volkov.formula.model.CircuitsResponse;
import ru.volkov.formula.service.CircuitService;

@RestController
public class CurcuitController {

    private final CircuitApi circuitApi;
    private final CircuitService service;

    @Autowired
    public CurcuitController(CircuitApi circuitApi, CircuitService service) {
        this.circuitApi = circuitApi;
        this.service = service;
    }
    
    @GetMapping("/circuits")
    @ResponseBody
    public CircuitsResponse getAllCircuits() {
        return service.saveAllCircuits();
    }

    @GetMapping("/{year}/circuits")
    public CircuitsResponse getCircuitsByYear(
            @PathVariable(value = "year") int year) {
        return circuitApi.getCircuitsByYear(year);
    }

    @GetMapping("/{year}/{round}/circuits")
    public CircuitsResponse getCircuitsResponseByYearAndRound(
            @PathVariable(value = "year") int year,
            @PathVariable(value = "round") int round) {
        return circuitApi.getCircuitsByYearAndRound(year, round);
    }
}
