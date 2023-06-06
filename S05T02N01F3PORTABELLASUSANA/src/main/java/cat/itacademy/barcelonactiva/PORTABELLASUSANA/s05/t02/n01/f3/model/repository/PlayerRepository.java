package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.model.repository;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.model.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

    Optional<Player> findPlayerByName(String name);
}
