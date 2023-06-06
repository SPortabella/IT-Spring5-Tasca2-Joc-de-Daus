package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.repository;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.domain.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends MongoRepository<Game,String> {

    List<Object> findGamesByPlayer_Id (String string);

}
