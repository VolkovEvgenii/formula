package ru.volkov.formula.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.curcuit")
public class CircuitProperties {

    private String circuitPath;
    private Integer queryLimit;
}
