package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public PlayerDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public PlayerDTO(String name) {
        this.name = name;
    }

}
