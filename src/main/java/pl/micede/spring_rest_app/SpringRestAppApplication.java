package pl.micede.spring_rest_app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.micede.spring_rest_app.configuration.WorkshopCarRent;
// jak się tworzy własne SINGLETONY
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Rest app",
                version = "1.0.0"
        )
)
@RequiredArgsConstructor
@Slf4j
public class SpringRestAppApplication implements CommandLineRunner {
    private final WorkshopCarRent workshopCarRent;
    public static void main(String[] args) {
        SpringApplication.run(SpringRestAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        workshopCarRent.showCarRentInfo();
        log.trace("Logi z poziomu TRACE");
        log.debug("Logi z poziomu DEBUG");
        log.info("Logi z poziomy INFO");
        log.warn("Logi z poziomu WARN");
        log.error("Logi z poziomu ERROR");
    }
}
