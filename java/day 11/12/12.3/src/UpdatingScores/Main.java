package UpdatingScores;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(
                List.of(
                        new Player("Alice", 10),
                        new Player("Bob", 15),
                        new Player("Charlie", 20)
                )
        );

        players.replaceAll((player) -> {
            player.setScore(player.getScore() * 2);
            return player;
        });

        System.out.println(players);
    }
}
