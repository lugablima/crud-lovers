package com.crudlover.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlover.api.dto.CarDTO;
import com.crudlover.api.model.Car;
import com.crudlover.api.repository.CarRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    
    @Autowired
    private CarRepository repository;

    @GetMapping
    public List<Car> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody @Valid CarDTO req) {
        repository.save(new Car(req));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req) {
        repository.findById(id).map(car -> {
            car.setModel(req.model());
            car.setManufacturer(req.manufacturer());
            car.setManufacturingDate(req.manufacturingDate());
            car.setPrice(req.price());
            car.setModelYear(req.modelYear());

            return repository.save(car);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
