package ch.bfh.swos.camp.config;

import ch.bfh.swos.camp.service.HeroService;
import ch.bfh.swos.camp.service.PartyService;
import ch.bfh.swos.camp.service.impl.DefaultHeroService;
import ch.bfh.swos.camp.service.impl.DefaultPartyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public HeroService heroService() {
        return new DefaultHeroService();
    }

    @Bean
    public PartyService partyService() {
        return new DefaultPartyService();
    }
}
