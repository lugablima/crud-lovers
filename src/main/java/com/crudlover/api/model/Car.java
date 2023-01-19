package com.crudlover.api.model;

import java.util.Date;

import com.crudlover.api.dto.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Car {

    public Car(CarDTO carDTO) {
        this.model = carDTO.model();
        this.manufacturer = carDTO.manufacturer();
        this.manufacturingDate = carDTO.manufacturingDate();
        this.price = carDTO.price();
        this.modelYear = carDTO.modelYear();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 50, nullable = false)
    private String model;

    @Column(length = 50, nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private Date manufacturingDate;

    @Column(scale = 2, nullable = false)
    private double price;

    @Column(precision = 4, nullable = false)
    private int modelYear;
}
