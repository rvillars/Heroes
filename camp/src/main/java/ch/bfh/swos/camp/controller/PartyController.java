package ch.bfh.swos.camp.controller;

import ch.bfh.swos.camp.model.Hero;
import ch.bfh.swos.camp.model.Party;
import ch.bfh.swos.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class PartyController {

    @Autowired
    private PartyService partyService;

    @Autowired
    private RepositoryEntityLinks entityLinks;

    @GetMapping(value = "/createParty")
    public Party createParty(@RequestParam String name) {
        Party party = partyService.createParty(name);
        party.add(linkTo(methodOn(PartyController.class).createParty(name)).withSelfRel());
        for (int i = 0; i < party.getMembers().size(); i++) {
            party.add(entityLinks.linkToSingleResource(Hero.class, party.getMembers().get(i).getId()).withRel("hero"+i));
        }
        return party;
    }

}
