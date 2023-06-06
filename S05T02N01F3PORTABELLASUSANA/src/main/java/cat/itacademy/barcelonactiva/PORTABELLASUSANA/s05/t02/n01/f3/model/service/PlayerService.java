package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.model.service;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.model.domain.Player;

public interface PlayerService {

    PlayerDTO createPlayer(PlayerDTO playerDTO);

    Object updatePlayer(Integer id, PlayerDTO playerDTO);

    Player getPlayerById(Integer id);

}
