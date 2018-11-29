package ch.bfh.swos.prompter.client;

import ch.bfh.swos.prompter.model.Party;
import org.springframework.hateoas.Resource;

public interface CampClient {

    Resource<Party> createParty(String name);

}
