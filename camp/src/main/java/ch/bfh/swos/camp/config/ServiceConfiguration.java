package ch.bfh.swos.camp.config;

import ch.bfh.swos.camp.service.HeroService;
import ch.bfh.swos.camp.service.PartyService;
import ch.bfh.swos.camp.service.impl.DefaultHeroService;
import ch.bfh.swos.camp.service.impl.DefaultPartyService;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

@Configuration
@EnableMongoRepositories(basePackages = "ch.bfh.swos.camp.repository")
public class ServiceConfiguration {

    @Bean
    public HeroService heroService() {
        return new DefaultHeroService();
    }

    @Bean
    public PartyService partyService() {
        return new DefaultPartyService();
    }

    @Bean
    @DependsOn("mongo")
    public MongoClient mongoClient() {
        return new MongoClient("localhost");
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "heroes");
    }

    @Bean(destroyMethod="close")
    public Mongo mongo() throws IOException {
        return new EmbeddedMongoBuilder()
                .version("3.4.17")
                .bindIp("localhost")
                .port(27017)
                .build();
    }
}
