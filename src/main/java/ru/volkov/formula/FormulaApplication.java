package ru.volkov.formula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class FormulaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormulaApplication.class, args);
    }

}
