import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Race {

    public static void main(String[] args){
        System.out.println("Entre com a quantidade de jogadores que participarao da corrida");
        Scanner scanner = new Scanner(System.in);
        int numPlayers = scanner.nextInt();

        List<PlayerThread> players = createPlayersList(numPlayers);
        startRace(players);
    }

    private static List<PlayerThread> createPlayersList(int numPlayers) {
        List<PlayerThread> players = new ArrayList<>();
        Route route = new Route(500, 5000);
        for (int i = 0; i<numPlayers; i++){
            PlayerThread player = new PlayerThread("Player " + i, route);
            players.add(player);
        }
        return players;
    }

    private static void startRace(List<PlayerThread> players) {
        for(int i = 0; i<players.size(); i++){
            PlayerThread player = players.get(i);
            player.start();
        }
    }
}
