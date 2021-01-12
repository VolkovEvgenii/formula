package ru.volkov.formula.api;

import org.springframework.http.ResponseEntity;
import ru.volkov.formula.model.CircuitsResponse;

public interface CircuitApi {

    ResponseEntity<CircuitsResponse> getAllCircuits();

    CircuitsResponse getCircuitsByYear(int year);

    CircuitsResponse getCircuitsByYearAndRound(int year, int round);
}
