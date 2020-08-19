package ch.bfh.swos.prompter.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class PromoterSink {

    private static final Logger LOG = LoggerFactory.getLogger(PromoterSink.class);

    @StreamListener(Sink.INPUT)
    public void promoteWinner(String winner) {
        LOG.info("And the winner is: Party '"+winner+"'");
    }
}
