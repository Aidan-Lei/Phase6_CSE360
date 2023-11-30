import java.util.HashMap;

public class Proto6 {

    // Simulate a database to store player information and game state.
	//ANTI CHEAT
	//BY: Aleksa Tomasevic

    private HashMap<String, Player> playerDatabase = new HashMap<>();



    public class Player {

        private boolean isCheating;



        public Player() {

            this.isCheating = false;

        }



        public boolean isCheating() {

            return isCheating;

        }



        public void setCheating(boolean cheating) {

            isCheating = cheating;

        }

    }



    public void checkForCheating(String playerName, String gameData) {

        Player player = playerDatabase.get(playerName);



        // Simulate checking game data for cheating behavior.

        if (gameData.contains("cheatKeyword")) {

            player.setCheating(true);

        }

    }



    public static void main(String[] args) {

        Proto6 antiCheatSystem = new Proto6();



        // Simulate players and game data.

        antiCheatSystem.playerDatabase.put("Player1", antiCheatSystem.new Player());

        antiCheatSystem.playerDatabase.put("Player2", antiCheatSystem.new Player());



        String gameDataPlayer1 = "Some game data without cheating.";

        String gameDataPlayer2 = "Some game data with cheatKeyword.";



        // Check for cheating behavior.

        antiCheatSystem.checkForCheating("Player1", gameDataPlayer1);

        antiCheatSystem.checkForCheating("Player2", gameDataPlayer2);



        // Report cheating status.

        System.out.println("Player1 is cheating: " + antiCheatSystem.playerDatabase.get("Player1").isCheating());

        System.out.println("Player2 is cheating: " + antiCheatSystem.playerDatabase.get("Player2").isCheating());

    }

}	
