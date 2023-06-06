package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.repository;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player,String> {

    Optional<Player> findPlayerByName(String name);
}
