package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.service;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.dto.RankingDTO;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.repository.GameRepository;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    PlayerService playerService;
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;

    public GameServiceImpl(PlayerService playerService,
                           GameRepository gameRepository,
                           PlayerRepository playerRepository) {
        this.playerService = playerService;
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public Object playGame(Integer id) {
        Player player = playerService.getPlayerById(id);

        Game game = new Game(player, throwDices());
        gameRepository.save(game);
        return game;
    }

    @Override
    public String deleteGamesByIdPlayer(Integer id) {

        List<Object> objets = gameRepository.findGamesByPlayer_Id(id);
        if (objets.isEmpty() || objets.size() == 0)
            return "Player with id " + id + " has no games";
        else {
            objets.stream().forEach(game -> {
                gameRepository.delete((Game) game);
            });

            return "Games deleted";
        }
    }

    @Override
    public List<Object> getAllGamesByIdPlayer(Integer id) {

        return gameRepository.findGamesByPlayer_Id(id);
    }

    @Override
    public List<RankingDTO> getRankingGames() {

        List<RankingDTO> rankingDTOS = calcRanking();

        return rankingDTOS;

    }

    @Override
    public String getWinnerRankingPlayer() {
        List<RankingDTO> rankingDTOS = calcRanking();
        if (!rankingDTOS.isEmpty())
            //TODO Returns all the best ones with the same ranking.
            return rankingDTOS.stream()
                    .filter(x -> x.getSuccessRate() == rankingDTOS.get(0).getSuccessRate())
                    .toList()
                    .toString();
        else
            return "There aren't games";
    }

    @Override
    public String getLoserRankingPlayer() {
        List<RankingDTO> rankingDTOS = calcRanking();
        if (!rankingDTOS.isEmpty())
            //TODO Returns all the worst with the same ranking
            return rankingDTOS.stream()
                    .filter(x -> x.getSuccessRate() == rankingDTOS.get(rankingDTOS.size() - 1).getSuccessRate())
                    .toList()
                    .toString();
        else
            return "There aren't games";
    }

    private List<RankingDTO> calcRanking() {
        List<RankingDTO> rankingDTOS = new ArrayList<>();
        List<Player> players = playerRepository.findAll();
        List<Game> games = gameRepository.findAll();
        for (Player player : players) {
            Integer id = player.getId();
            int countGameWin = (int) games.stream()
                    .filter(x -> x.getPlayer().getId() == id && x.getPoints() == 7)
                    .count();
            int totalGames = (int) games.stream()
                    .filter(x -> x.getPlayer().getId() == id)
                    .count();
            double successRate = 0.0F;
            if (countGameWin > 0) {
                successRate = (double) countGameWin / totalGames;
            }
            //TODO If a player has not played any game, he does not enter the ranking
            if (totalGames != 0) {
                RankingDTO rankingDTO = new RankingDTO(player.getId(), player.getName(), countGameWin,
                        totalGames, successRate);
                rankingDTOS.add(rankingDTO);
            }
        }

        Collections.sort(rankingDTOS, new SortRankingBySuccessRate().reversed());
        return rankingDTOS;
    }

    private class SortRankingBySuccessRate implements Comparator<RankingDTO> {

        @Override
        public int compare(RankingDTO o1, RankingDTO o2) {
            if (Double.compare(o1.getSuccessRate(), o2.getSuccessRate()) == 0) {
                return 0;
            } else if (Double.compare(o1.getSuccessRate(), o2.getSuccessRate()) < 0) {
                return -1;
            } else {
                return +1;
            }
        }
    }

    private Integer throwDices() {
        Integer dice1 = new Random().nextInt(6) + 1;
        Integer dice2 = new Random().nextInt(6) + 1;
        return dice1 + dice2;
    }

}
