package ch.bfh.swos.camp.service.impl;

import ch.bfh.swos.camp.model.Hero;
import ch.bfh.swos.camp.model.Party;
import ch.bfh.swos.camp.service.HeroService;
import ch.bfh.swos.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultPartyService implements PartyService {

    @Autowired
    private HeroService heroService;

    public Party createParty(String name) {
        System.out.println("Creating party with name "+name+"...");
        Party party = new Party();
        party.setName(name);
        List<Hero> members = new ArrayList<Hero>();
        for (int i = 0; i < 4; i++) {
            members.add(heroService.createHero("Hero"+i));
        }
        System.out.println("Adding heroes to party "+name);
        party.setMembers(members);
        System.out.println("Party "+name+" has been created.");
        return party;
    }
}
