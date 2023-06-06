package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.service;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.dto.RankingDTO;

import java.util.List;

public interface GameService {


    Object playGame(String id);

    String deleteGamesByIdPlayer(String id);

    List<Object> getAllGamesByIdPlayer(String id);

    List<RankingDTO> getRankingGames();

    public String getWinnerRankingPlayer();

    public String getLoserRankingPlayer();

}
