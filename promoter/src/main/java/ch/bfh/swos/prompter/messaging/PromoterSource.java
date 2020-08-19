package ch.bfh.swos.prompter.messaging;

import ch.bfh.swos.prompter.model.Party;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableBinding(Source.class)
public class PromoterSource {

    private static final Logger LOG = LoggerFactory.getLogger(PromoterSource.class);

    @Autowired
    private Source source;

    public List<Party> sendChallengersToArena(List<Party> challengers) {
        source.output().send(MessageBuilder.withPayload(challengers).build());
        LOG.info("Challangers sent to arena");
        return  challengers;
    }
}
