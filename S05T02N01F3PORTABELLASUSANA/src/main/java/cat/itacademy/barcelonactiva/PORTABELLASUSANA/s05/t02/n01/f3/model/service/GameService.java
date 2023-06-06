package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.model.service;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.model.dto.RankingDTO;

import java.util.List;

public interface GameService {


    Object playGame(Integer id);

    String deleteGamesByIdPlayer(Integer id);

    List<Object> getAllGamesByIdPlayer(Integer id);

    List<RankingDTO> getRankingGames();

    public String getWinnerRankingPlayer();

    public String getLoserRankingPlayer();

}
