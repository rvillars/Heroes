package ch.bfh.swos.prompter.client;

import ch.bfh.swos.prompter.model.Party;
import org.springframework.hateoas.EntityModel;

public interface CampClient {

    EntityModel<Party> createParty(String name);

}
