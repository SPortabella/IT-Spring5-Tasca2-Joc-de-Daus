package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.service;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.domain.Player;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.dto.PlayerDTO;

public interface PlayerService {

    PlayerDTO createPlayer(PlayerDTO playerDTO);

    Object updatePlayer(String id, PlayerDTO playerDTO);

    Player getPlayerById(String id);

}
