package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.controllers;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.exceptions.ElementsDoesntEqualsException;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.exceptions.InvalidElementException;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.domain.Player;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.service.PlayerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dicegame/players")
public class PlayerController {

    PlayerServiceImpl playerService;

    public PlayerController(PlayerServiceImpl playerService) {
        this.playerService = playerService;
    }

    //TODO Create a player
    @PostMapping("")
    public ResponseEntity<Object> createPlayer(@RequestBody PlayerDTO playerDTO) {
        try {
            return ResponseEntity.ok().body(playerService.createPlayer(playerDTO));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //TODO Update Player name
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePlayer(@PathVariable String id,
                                               @RequestBody PlayerDTO playerDTO) {
        try {
            if (playerDTO.getId() == null || id == null ) throw new InvalidElementException(Player.class);
            if (!playerDTO.getId().equals(id)) throw new ElementsDoesntEqualsException(Player.class, id, playerDTO.getId());
            return ResponseEntity.ok().body(playerService.updatePlayer(id, playerDTO));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
