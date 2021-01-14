package ch.bfh.swos.prompter.client;

import ch.bfh.swos.prompter.model.Party;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "arena-service")
public interface ArenaClient {

    @CircuitBreaker(name = "arena-service", fallbackMethod = "battleFallback")
    @PostMapping("/battle")
    String battle(@RequestBody List<Party> challangers);

    default String battleFallback(Throwable throwable) {
        return "The battle has to be postponed because the arena is occupied at the moment";
    }
}

