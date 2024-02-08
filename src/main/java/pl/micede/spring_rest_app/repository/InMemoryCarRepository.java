package pl.micede.spring_rest_app.repository;

import lombok.extern.slf4j.Slf4j;
import pl.micede.spring_rest_app.exceptions.ExistingCarException;
import pl.micede.spring_rest_app.exceptions.NoSuchCarException;
import pl.micede.spring_rest_app.model.Car;
import pl.micede.spring_rest_app.model.FuelType;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
@Slf4j
//@Repository
public class InMemoryCarRepository implements CarRepository {
//    @Autowired
//    private CarService carService; -> robiąc tak wywalimy appke bo zapętlimy czytanie beanów

    // string jest dobrym obiektem jako klucz bo string jest nie mutowalny, bo ma nadpisane w sobie equals&hashcode
    private static Map<String, Car> carMap;

    //blok statyczny- po odpaleniu appki odrazu się zaainicjalizują zmienne
    static {
        carMap = new HashMap<>();

        carMap.put("ABC1234", Car.builder()
                .brand("Audi")
                .model("A6")
                .productionYear(2014)
                .carValue(new BigDecimal("40000"))
                .fuelType(FuelType.DIESEL)
                .build());
        carMap.put("DEF5678", Car.builder()
                .brand("VW")
                .model("Passat")
                .productionYear(2015)
                .carValue(new BigDecimal("5000"))
                .fuelType(FuelType.DIESEL)
                .build());
        carMap.put("XYZ0123", Car.builder()
                .brand("Skoda")
                .model("Octavia")
                .productionYear(2011)
                .carValue(new BigDecimal("65000"))
                .fuelType(FuelType.GAS)
                .build());
        carMap.put("WWW5689", Car.builder()
                .brand("Hyundai")
                .model("i30")
                .productionYear(2018)
                .carValue(new BigDecimal("35000"))
                .fuelType(FuelType.LPG)
                .build());
        carMap.put("TES12345", Car.builder()
                .brand("Tesla")
                .model("S3")
                .productionYear(2023)
                .carValue(new BigDecimal("150000"))
                .fuelType(FuelType.ELECTRIC)
                .build());
    }

    @Override
    public List<Car> getAllCars() {
        //wrzucamy w arraylistę bo niezgodny typ. prosi o collection a my chcemy listę
        return new ArrayList<>(carMap.values());
    }

    @Override
    public Optional<Car> findByCarPlate(String registrationNumber) {
        // Car car = carMap.get(carPlate);
        if(!carMap.containsKey(registrationNumber)) {
            throw new NoSuchCarException(registrationNumber);
        }
        return Optional.ofNullable(carMap.get(registrationNumber));
    }

    @Override
    public List<Car> addCar(String registrationNumber, Car newCar) {
        if (carMap.containsKey(registrationNumber)) {
            //log.warn("Samochod o podanej tablicy juz istnieje w bazie: " + registrationNumber);
            //return new ArrayList<>();
            throw new ExistingCarException(registrationNumber);
        }
            carMap.put(registrationNumber, newCar);

        return new ArrayList<>(carMap.values());
    }

    @Override
    public List<Car> updateCar(String registrationNumber, BigDecimal newCarValue) {
        Optional<Car> car = Optional.ofNullable(carMap.get(registrationNumber));
        //tu opcja w programowaniem funkcyjnym, ale trzeba sprawdzić w obu przypadkach czy jest obecny a później dodać jeśli nie null
        //car.ifPresent(c -> c.setCarValue(newValue));
        if(!carMap.containsKey(registrationNumber)) {
            throw new NoSuchCarException(registrationNumber);
        }
        if(car.isPresent()){
            car.get().setCarValue(newCarValue);
        }

        return new ArrayList<>(carMap.values());
    }

    @Override
    public List<Car> showInYearsPeriod(Integer startPeriod, Integer endPeriod) {
        ArrayList<Car> cars = new ArrayList<>(carMap.values());
        return cars.stream()
                .filter(c -> startPeriod < c.getProductionYear() && c.getProductionYear() <= endPeriod)
                .collect(Collectors.toList());

    }

    @Override
    public List<Car> getCarByFuelType(FuelType fuelType) {
         return carMap.values()
                 .stream()
                .filter(c -> c.getFuelType().equals(fuelType))
                .collect(Collectors.toList());

    }

    @Override
    public List<Car> deleteCarByRegistration(String registrationNumber) {
        if(!carMap.containsKey(registrationNumber)) {
            throw new NoSuchCarException(registrationNumber);
        }
        carMap.remove(registrationNumber);
        return new ArrayList<>(carMap.values());
    }

    @Override
    public List<Car> deleteCarByBrandAndModel(String brand, String model) {

        carMap.entrySet()
                .removeIf(c -> c.getValue().getBrand().equals(brand) && c.getValue().getModel().equals(model));
        return new ArrayList<>(carMap.values());



//        carMap = carMap.entrySet().stream()
//                .filter(c -> !c.getValue().getBrand().equals(brand) && !c.getValue().getModel().equals(model))
//                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
//        return new ArrayList<>(carMap.values());
    }


}
