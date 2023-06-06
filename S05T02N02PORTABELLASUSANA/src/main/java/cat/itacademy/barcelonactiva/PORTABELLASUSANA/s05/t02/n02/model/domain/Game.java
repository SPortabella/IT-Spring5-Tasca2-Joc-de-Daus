package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "game")
@JsonPropertyOrder({"id", "points", "player"})

public class Game {

    @Id
    private String id;
    private Integer points;
    @ManyToOne(optional = false)
    private Player player;

    public Game(Player player, Integer points) {
        this.player = player;
        this.points = points;
    }

    public Player getPlayer() {
        return player;
    }

    public Integer getPoints() {
        return points;
    }

    @Override
    public String toString() {
            return player  +
                    "\nYou've got " + points + " points " + " " +
                    ((points == 7) ? " You WIN!!!!" : " You LOST!!!")
                    + "\n";

    }
}
