package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Game {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;
    private Integer points;
    //@ManyToOne(optional = false)
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public Game(Player player, Integer points) {
        this.player = player;
        this.points = points;
    }

    @Override
    public String toString() {
            return player  +
                    "You've got " + points + " points " + " " +
                    ((points == 7) ? " You WIN!!!!" : " You LOST!!!")
                    + "\n";

    }
}
