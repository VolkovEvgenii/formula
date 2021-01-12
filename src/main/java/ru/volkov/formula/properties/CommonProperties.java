package ru.volkov.formula.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.common")
public class CommonProperties {

    private String scheme;
    private String host;
    private String basePath;
    private String responseType;
}
