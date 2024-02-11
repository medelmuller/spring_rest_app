package pl.micede.spring_rest_app.configbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.micede.spring_rest_app.repository.car_repo.CarRepository;
import pl.micede.spring_rest_app.repository.car_repo.InMemoryCarRepository;
import pl.micede.spring_rest_app.service.car_service.CarService;

@Configuration
public class Config {

    @Bean
    public CarRepository carRepository() {
        return new InMemoryCarRepository();
    }

    @Bean
    public CarService carService(CarRepository carRepository) {
        //return new CarService(carRepository()); -> tak lepiej jeśli jakaś logika będzie zapisana w carRepository()
        return new CarService(carRepository);
    }
}
