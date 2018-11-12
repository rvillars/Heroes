package ch.bfh.swos.camp.service.impl;

import ch.bfh.swos.camp.model.Hero;
import ch.bfh.swos.camp.repository.HeroRepository;
import ch.bfh.swos.camp.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class DefaultHeroService implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public Hero createHero(String name) {
        System.out.println("Creating hero with name "+name+"...");
        Hero hero = new Hero();
        hero.setName(name);

        int atk = new Random().nextInt(100);
        hero.setAtk(atk);
        System.out.println(name+" has ATK value of "+hero.getAtk());

        int def = new Random().nextInt(100);
        hero.setDef(def);
        System.out.println(name+" has DEF value of "+hero.getDef());

        hero.setHp(100);
        System.out.println(name+" has HP value of "+hero.getHp());

        String id = heroRepository.save(hero).getId();

        System.out.println("Hero "+name+" has been created");
        System.out.println("Heros with ATK greater than 50: "+heroRepository.countByAtkGreaterThan(50));

        return heroRepository.findById(id).get();
    }
}
