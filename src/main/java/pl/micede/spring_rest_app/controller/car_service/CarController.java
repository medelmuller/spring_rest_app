package pl.micede.spring_rest_app.controller.car_service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.micede.spring_rest_app.controller.car_service.request.DeleteRequest;
import pl.micede.spring_rest_app.controller.car_service.response.DeleteCarParamsResp;
import pl.micede.spring_rest_app.model.Car;
import pl.micede.spring_rest_app.model.Client;
import pl.micede.spring_rest_app.model.FuelType;
import pl.micede.spring_rest_app.service.car_service.CarService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@Slf4j
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> listOfCars() {
        List<Car> allCars = carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }

    @GetMapping("/car/{carPlate}")
    public ResponseEntity<Car> withPathVariable(@PathVariable String carPlate) {
        Optional<Car> carByPlate = carService.getByPlate(carPlate);

        return carByPlate.map(optCar -> ResponseEntity.ok(optCar)).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).body(Car.builder().build()));
    }

    @GetMapping("/number") // w postmanie jako Key trzeba dodać taką nazwę jak po @RequestParam
    public ResponseEntity<Car> getByPlateRequestParam(@RequestParam String registrationNumber) {
        Optional<Car> carByPlate = carService.getByPlate(registrationNumber);

        return carByPlate.map(optCar -> ResponseEntity.ok(optCar))
                         .orElse(null);
    }

    @PostMapping("/{number}")
    public ResponseEntity<List<Car>> addCar(@PathVariable String number, @RequestBody @Valid Car car) {
        List<Car> cars = carService.addCar(number, car);
        return ResponseEntity.ok(cars);
        //return cars.isEmpty() ? ResponseEntity.status(HttpStatus.CONFLICT).build() : ResponseEntity.ok(cars); //-> to jeśli nie mamy obsługi wyjątku w handlerze
    }


    // w POSTMANIE nie wpisujemy wartości w klamrach {} jak przy obiekcie tylko samą wartość
    @PatchMapping("/patchValue/{number}")
    public ResponseEntity<List<Car>> updateCar(@PathVariable String number, @RequestBody BigDecimal newCarValue) {
        List<Car> carList = carService.updateCar(number, newCarValue);

        return ResponseEntity.ok(carList);
        //return ResponseEntity.ok(carService.updateCar(number, newCarValue));
    }

    @GetMapping("/years")
    public ResponseEntity<List<Car>> showInYearsPeriod(@RequestParam Integer startPeriod, Integer endPeriod) {
        List<Car> carList = carService.showInYearsPeriod(startPeriod, endPeriod);
        return ResponseEntity.ok(carList);
    }

    @GetMapping("/fuel/{fuelType}")
    public ResponseEntity<List<Car>> getCarsByFuelType(@PathVariable FuelType fuelType) {
        List<Car> carsByFuelType = carService.getCarsByFuelType(fuelType);
        return ResponseEntity.ok(carsByFuelType);
    }

    @DeleteMapping("/delete/{registrationNumber}")
    public ResponseEntity<List<Car>> deleteCarByRegistrationNumber(@PathVariable String registrationNumber) {
        List<Car> carList = carService.deleteByRegistrationNumber(registrationNumber);
        return ResponseEntity.ok(carList);
    }

    @DeleteMapping("/delete")
    // RequestBody odpowiada na Obiekt JSON
    public ResponseEntity<List<Car>> deleteByBrandAndModel(@RequestBody DeleteRequest request) {
        List<Car> carList = carService.deleteByBrandAndModel(request.getBrand(), request.getModel());
        return ResponseEntity.ok(carList);
    }

    @DeleteMapping("/delete2")
    // RequestBody odpowiada na Obiekt JSON
    public ResponseEntity<DeleteCarParamsResp> deleteByBrandAndModel2(@RequestBody DeleteRequest request) {
        log.info("Otrzymalismy request dotyczacy usuniecia samochodu z wypozyczalni" + request.getBrand() + request.getModel());
        DeleteCarParamsResp response = new DeleteCarParamsResp();
        List<Car> carList = carService.deleteByBrandAndModel(request.getBrand(), request.getModel());

        response.setAmount(carList.size());
        response.setCars(carList);
        return ResponseEntity.ok(response);
    }

}
