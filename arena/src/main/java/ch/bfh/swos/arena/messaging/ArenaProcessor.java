package ch.bfh.swos.arena.messaging;

import ch.bfh.swos.arena.model.Party;
import ch.bfh.swos.arena.service.BattleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableBinding(Processor.class)
public class ArenaProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(ArenaProcessor.class);

    @Autowired
    private BattleService battleService;

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String battle(List<Party> challengers) {

        if (challengers.size() != 2) {
            throw new RuntimeException("Only 2 challengers at the same time are allowed in the arena.");
        }

        Party challengee = challengers.get(0);
        Party challenger = challengers.get(1);
        String winner = battleService.battle(challengee, challenger);
        LOG.info("The winner of the battle between '" + challengee.getName() + "' and '" + challenger.getName() + "' was '" + winner + "'!");
        return winner;
    }
}
