package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.service;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.dto.PlayerDTO;

public interface PlayerService {

    PlayerDTO createPlayer(PlayerDTO playerDTO);

    Object updatePlayer(Integer id, PlayerDTO playerDTO);

    Player getPlayerById(Integer id);

}
