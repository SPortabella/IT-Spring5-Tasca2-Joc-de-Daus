package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.model.dto;

import java.io.Serializable;
import java.text.DecimalFormat;

public class RankingDTO implements Serializable {

    private String idPlayer;
    private String namePlayer;
    private int gamesWon;
    private int gamesTotal;
    private double successRate;

    public RankingDTO(String idPlayer, String namePlayer, int gamesWon, int gamesTotal, double successRate) {
        this.idPlayer = idPlayer;
        this.namePlayer = namePlayer;
        this.gamesWon = gamesWon;
        this.gamesTotal = gamesTotal;
        this.successRate = successRate;
    }

    public double getSuccessRate() {
        return successRate;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##0.00");
        return "id: " + idPlayer +
                " " + namePlayer +
                " , Won= " + gamesWon +
                " , Total=" + gamesTotal +
                " , successRate=" + df.format(successRate * 100) + "%\n";
    }
}
