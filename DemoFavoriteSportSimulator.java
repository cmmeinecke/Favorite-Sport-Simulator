import java.util.Scanner;

//creates class for demo of FavoriteSportSimulator program
public class DemoFavoriteSportSimulator {

//create main method to demonstrate functionality of program
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Get the number of games
        System.out.print("Enter the number of games: ");
        int numGames = keyboard.nextInt();
        keyboard.nextLine();

        // Create an array to store player information
        Player[] players = new Player[2];

        // for loop that collects player names for each game
        for (int i = 0; i < players.length; i++) {
            System.out.print("Please enter the name of Player " + (i + 1) + ": ");
            String playerName = keyboard.nextLine();
            players[i] = new Player(playerName, numGames);
        }

        // for loop to get scores for each player and game
        for (int game = 1; game <= numGames; game++) {
            for (Player player : players) {
                System.out.print("Enter score for " + player.getName() + " in Game " + game + ": ");
                int score = keyboard.nextInt();
                player.setScore(game, score);
            }
        }
        //close keyboard
        keyboard.close();

        // Print player information using accessor methods
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");  //print player with number
            System.out.println("Player: " + players[i].getName());  //prints player with name
            System.out.println("Game Information:");    //prints "Game Information"
            //prints game information
            for (int j = 0; j < numGames; j++) {
                System.out.println("Game " + (j + 1) + ": " + players[i].getScore(j + 1));
            }
            //prints average score
            System.out.println("Average Score: " + players[i].calculateAverage());
            System.out.println();
        }

        // Displays the player with the highest average
        int highestAveragePlayer = getHighestAveragePlayer(players);
        System.out.println("Player " + (highestAveragePlayer + 1) + " has the highest average score.");
    }

//calculates the player with the highest average
    private static int getHighestAveragePlayer(Player[] players) {
        int highestAveragePlayer = 0;
        for (int i = 1; i < players.length; i++) {
            if (players[i].calculateAverage() > players[highestAveragePlayer].calculateAverage()) {
                highestAveragePlayer = i;
            }
        }
        return highestAveragePlayer;    //returns the player with the highest average
    }
}