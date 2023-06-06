package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "player")
@JsonPropertyOrder({"id", "name", "date"})

public class Player {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Date date;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Player " + id + "-" + name;
    }
}