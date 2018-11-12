package ch.bfh.swos.camp;

import ch.bfh.swos.camp.config.ServiceConfiguration;
import ch.bfh.swos.camp.service.PartyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext configuredContext = new AnnotationConfigApplicationContext(ServiceConfiguration.class);

        PartyService partyServiceConfigured = configuredContext.getBean(PartyService.class);
        partyServiceConfigured.createParty("Party2");

        configuredContext.close();
    }
}
