package ch.bfh.swos.arena.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;

@Configuration
public class EmbeddedKafkaConfiguration {
    @Bean
    public EmbeddedKafkaBroker embeddedKafka() {
        EmbeddedKafkaBroker embeddedKafkaBroker = new EmbeddedKafkaBroker(1, false, "arenaTopic", "promoterTopic");
        embeddedKafkaBroker.brokerProperty("listeners", "PLAINTEXT://localhost:9092");
        embeddedKafkaBroker.brokerProperty("port", "9092");
        return embeddedKafkaBroker;
    }
}
