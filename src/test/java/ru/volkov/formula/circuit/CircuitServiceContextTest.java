package ru.volkov.formula.circuit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.volkov.formula.service.CircuitService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CircuitServiceContextTest {

    @Autowired
    CircuitService service;

    @Test
    public void contextLoad(){
        assertThat(service).isNotNull();
    }
}
