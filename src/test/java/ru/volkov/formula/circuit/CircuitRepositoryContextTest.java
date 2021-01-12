package ru.volkov.formula.circuit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.volkov.formula.repository.CircuitRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CircuitRepositoryContextTest {

    @Autowired
    CircuitRepository repository;

    @Test
    public void contestLoad(){
        assertThat(repository).isNotNull();
    }

}
