package AddingPrefixToPlayerNames;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(List.of(
                new Player("Alice", 25),
                new Player("Bob", 30),
                new Player("Charlie", 35)
        ));

        players.forEach((player) -> {
            player.setName("Player-" + player.getName());
        });
        System.out.println(players);
    }
}
