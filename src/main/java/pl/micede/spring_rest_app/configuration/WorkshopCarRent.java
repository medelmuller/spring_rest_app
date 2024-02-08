package pl.micede.spring_rest_app.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WorkshopCarRent {
    @Value("${workshop.info.ws-name}")
    private String wsName;
    @Value("${workshop.info.year-foundation}")
    private int yearFoundation;
    @Value("${workshop.info.owner}")
    private String owner;

    public void showCarRentInfo() {
        log.info(String.format("Car Rental name: [%s], year of foundation: [%d], owner's name: [%s] ", wsName, yearFoundation, owner));
    }
}
