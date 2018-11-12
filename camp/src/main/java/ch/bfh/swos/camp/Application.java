package ch.bfh.swos.camp;

import ch.bfh.swos.camp.config.ServiceConfiguration;
import ch.bfh.swos.camp.service.PartyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // Application context using java configuration for DI - less magic, more control, @Service annotations are obsolete.
        AnnotationConfigApplicationContext configuredContext = new AnnotationConfigApplicationContext(ServiceConfiguration.class);

        PartyService partyServiceConfigured = configuredContext.getBean(PartyService.class);
        partyServiceConfigured.createParty("Party2");

        configuredContext.close();
    }
}
