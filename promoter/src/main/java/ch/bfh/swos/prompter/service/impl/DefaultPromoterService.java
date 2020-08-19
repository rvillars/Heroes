package ch.bfh.swos.prompter.service.impl;

import ch.bfh.swos.prompter.client.CampClient;
import ch.bfh.swos.prompter.messaging.PromoterSource;
import ch.bfh.swos.prompter.model.Party;
import ch.bfh.swos.prompter.service.PromoterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultPromoterService implements PromoterService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultPromoterService.class);

    @Autowired
    private CampClient campClient;

    @Autowired
    private PromoterSource promoterSource;

    @Override
    public String promoteFight() {

        Party challengee = campClient.createParty("Challengee").getContent();
        Party challenger = campClient.createParty("Challenger").getContent();
        LOG.info("Todays battle is between Party '"+challengee.getName()+"' and Party '"+challenger.getName()+"'.");

        List<Party> challangers = new ArrayList<>();
        challangers.add(challengee);
        challangers.add(challenger);

        promoterSource.sendChallengersToArena(challangers);

        return  "Fight in progress...";
    }
}
