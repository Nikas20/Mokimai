package SortingPlayers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(List.of(
                new Player("Alice", 15),
                new Player("Bob", 20),
                new Player("Charlie", 20),
                new Player("Daisy", 10)
        ));

        players.sort((player1, player2) -> player2.getScore() - player1.getScore());
        System.out.println(players);

    }
}
