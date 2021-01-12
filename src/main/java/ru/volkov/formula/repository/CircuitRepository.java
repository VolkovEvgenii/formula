package ru.volkov.formula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.volkov.formula.entity.CircuitEntity;

public interface CircuitRepository extends JpaRepository<CircuitEntity, String> {
}
