package LoggingPlayerNames;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("Alice", 20),
                new Player("Bob", 30),
                new Player("Charlie", 25)
        );

        players.forEach(((player) -> {
            System.out.println("Player: " + player.getName() + ", Score: " + 25);
        }));
    }
}