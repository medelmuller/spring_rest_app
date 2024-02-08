package pl.micede.spring_rest_app.service.commercial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
//@Primary //to się daje jak się implementuje w dwóch różnych klasach ten sam interface
@Profile("!prod") // działa na wszystkich środowiskach nie oznaczonych jako prod
public class DefaultCustomerCommercialService implements CommercialService{
    @Override
    public void sendCommercialOffer(String commercialContent) {
        log.info("It's offer for default customers: " + commercialContent);
    }
}
