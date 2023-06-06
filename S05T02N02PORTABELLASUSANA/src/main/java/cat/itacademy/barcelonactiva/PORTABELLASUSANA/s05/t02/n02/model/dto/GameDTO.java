package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.dto;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.domain.Player;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class GameDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer points;
    private Player player;

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", points=" + points +
                ", player: " + player.getId() + "-" + player.getId();
    }
}
