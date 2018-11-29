package ch.bfh.swos.camp.repository;

import ch.bfh.swos.camp.model.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HeroRepository extends MongoRepository<Hero, String> {

    Long countByAtkGreaterThan(Integer atk);

}
