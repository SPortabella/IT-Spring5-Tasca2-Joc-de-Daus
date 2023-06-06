package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.dto;

import jakarta.persistence.Id;

import java.io.Serializable;

public class PlayerDTO implements Serializable {
    @Id
    private String id;
    private String name;

    public PlayerDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public PlayerDTO() {
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
