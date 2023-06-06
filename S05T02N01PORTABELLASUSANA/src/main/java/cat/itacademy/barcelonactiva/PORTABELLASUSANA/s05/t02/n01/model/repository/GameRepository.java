package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {

    List<Object> findGamesByPlayer_Id (Integer integer);

}
