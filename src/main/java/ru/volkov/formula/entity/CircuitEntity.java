package ru.volkov.formula.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "circuit", schema = "main")
public class CircuitEntity {

    @Id
    @Column(name = "id")
    private String circuitId;

    private String url;

    @Column(name = "name")
    private String circuitName;

    private String longitude;

    private String latitude;

    private String locality;

    private String country;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;
}
