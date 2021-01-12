package ru.volkov.formula.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.volkov.formula.model.CircuitsResponse;
import ru.volkov.formula.properties.CircuitProperties;
import ru.volkov.formula.properties.CommonProperties;
import ru.volkov.formula.service.CircuitService;

@Service
public class CircuitsApiImpl implements CircuitApi {
    public static final Logger LOG = LoggerFactory.getLogger(CircuitsApiImpl.class);

    private final CommonProperties commonProp;
    private final CircuitProperties circuitProp;

    @Autowired
    public CircuitsApiImpl(
            CommonProperties commonProp,
            CircuitProperties circuitProp) {
        this.commonProp = commonProp;
        this.circuitProp = circuitProp;
    }

    @Override
    public ResponseEntity<CircuitsResponse> getAllCircuits() {
        LOG.debug("Start to get all circuits");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance()
                .scheme(commonProp.getScheme())
                .host(commonProp.getHost())
                .path(commonProp.getBasePath())
                .pathSegment(circuitProp.getCircuitPath() + "." + commonProp.getResponseType())
                .queryParam("limit", circuitProp.getQueryLimit());
        LOG.debug("Current URL: '{}'", uriBuilder.toUriString());
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<CircuitsResponse> response = restTemplate.exchange(
                uriBuilder.toUriString(), HttpMethod.GET,
                entity, CircuitsResponse.class);
        LOG.debug("Response get successfully");
        return response;
    }

    @Override
    public CircuitsResponse getCircuitsByYear(int year) {
        LOG.debug("Start to get circuits by year with parameters: year - {}", year);
        LOG.debug("Circuits get successfully");
        return null;
    }

    @Override
    public CircuitsResponse getCircuitsByYearAndRound(int year, int round) {
        LOG.debug("Start to get circuits by year and round with parameters: year - {}, round - {}", year, round);
        LOG.debug("Circuits get successfully");
        return null;
    }
}
