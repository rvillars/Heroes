package ch.bfh.swos.camp.repository;

import ch.bfh.swos.camp.model.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends MongoRepository<Hero, String> {

    Long countByAtkGreaterThan(Integer atk);

}
