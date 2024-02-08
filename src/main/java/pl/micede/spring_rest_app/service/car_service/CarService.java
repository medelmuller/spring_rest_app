package pl.micede.spring_rest_app.service.car_service;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.micede.spring_rest_app.model.Car;
import pl.micede.spring_rest_app.model.FuelType;
import pl.micede.spring_rest_app.repository.CarRepository;
import pl.micede.spring_rest_app.repository.InMemoryCarRepository;

import java.math.BigDecimal;
import java.util.*;

//@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    public Optional<Car> getByPlate(String plate) {
        return carRepository.findByCarPlate(plate);
    }

    public List<Car> addCar(String registrationNumber, Car newCar){
        return carRepository.addCar(registrationNumber, newCar);
    }

    public List<Car> updateCar(String registrationNumber, BigDecimal newCarValue) {
        return carRepository.updateCar(registrationNumber, newCarValue);
    }

    public List<Car> showInYearsPeriod(Integer startPeriod, Integer endPeriod) {
        return carRepository.showInYearsPeriod(startPeriod, endPeriod);
    }

    public List<Car> getCarsByFuelType(FuelType fuelType) {
        return carRepository.getCarByFuelType(fuelType);
    }

    public List<Car> deleteByRegistrationNumber(String registrationNumber) {
        return carRepository.deleteCarByRegistration(registrationNumber);
    }

    public List<Car> deleteByBrandAndModel(String brand, String model) {
        return carRepository.deleteCarByBrandAndModel(brand, model);
    }
}
