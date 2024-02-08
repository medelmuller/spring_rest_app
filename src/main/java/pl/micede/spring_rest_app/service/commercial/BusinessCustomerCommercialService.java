package pl.micede.spring_rest_app.service.commercial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Profile("prod")
public class BusinessCustomerCommercialService implements CommercialService{
    @Override
    public void sendCommercialOffer(String commercialContent) {
      log.info("It's an offer for business customers: " + commercialContent);
    }
}
