package pl.micede.spring_rest_app.configbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.micede.spring_rest_app.configuration.WorkshopInfo;

@Configuration
public class ConfigWorkshopInfo {

    @Bean
    public WorkshopInfo workshopInfo() {
        return new WorkshopInfo();
    }

}
