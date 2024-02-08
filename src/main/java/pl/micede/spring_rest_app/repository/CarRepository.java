package pl.micede.spring_rest_app.repository;

import org.springframework.stereotype.Repository;
import pl.micede.spring_rest_app.model.Car;
import pl.micede.spring_rest_app.model.FuelType;

import java.math.BigDecimal;
import java.sql.Struct;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CarRepository {
    List<Car> getAllCars();

    Optional<Car> findByCarPlate(String carPlate);
// ustawiamy jako listę bo dostajemy info zwrotnę jako uzupełniona lista z nowym autem
    List<Car> addCar(String registrationNumber, Car newCar);

    //Za pomocą metody http PATCH, stwórz endpoint umożliwiający edycję wartości samochodu na podstawie tablicy rejestracyjnej.
    // Nową wartość samochodu (carValue) przekaż za pomocą @RequestBody. Numery rejestracyjne za pomocą @PathVariable/@RequestParam.
    List<Car> updateCar(String registrationNumber, BigDecimal newCarValue);

    List<Car> showInYearsPeriod(Integer startPeriod, Integer endPeriod);

    List<Car> getCarByFuelType(FuelType fuelType);

    List<Car> deleteCarByRegistration(String registrationNumber);

    List<Car> deleteCarByBrandAndModel(String brand, String model);
}
