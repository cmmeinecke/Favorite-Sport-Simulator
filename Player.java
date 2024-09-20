/* PROGRAM: FavoriteSportSimulator
 @Author  caitlin.meinecke
 This program collects scores for each player for each game and calculates the average,
  while also calculating the player with the highest average.
*/

//Create class to represent the Players
public class Player {
    private String name;    //holds name
    private int[][] scores;     //2-dimensional array for scores

    //creates constructor Player to initialize name and number of games
    public Player(String name, int numGames) {
        this.name = name;
        this.scores = new int[numGames][2];
    }

    //getter method to retrieve player name
    public String getName() {
        return name;
    }

    //setter method to set score for each game
    public void setScore(int game, int score) {
        scores[game - 1][0] = game;     //stores game number
        scores[game - 1][1] = score;    //stores score
    }

    //method that calculates the average of the scores and returns the average
    public double calculateAverage() {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i][1]; // Accumulate the scores
        }
        return sum / scores.length; // Calculates and returns average
    }


    // Mutator method to set the name of the player
    public void setName(String name) {

        this.name = name;
    }

    //accessor method to retrieve scores for specific games
    public int getScore(int game) {

        return scores[game - 1][1];     //retrieves game scores
    }

    //mutator method to set the number of games and reset scores
    public void setNumGames(int numGames) {

        this.scores = new int[numGames][2];     //resets scores
    }

    //toString method to represent PLayer info as a string
    public String toString() {
        String result = "Player:\n";
        result += "Player: " + name + "\n";     //connect player name to string result
        result += "Game Information:\n";        //string that displays "Game Information"

        //iterates through each of the games
        for (int i = 0; i < scores.length; i++) {
            //connects game number with its score to string result
            result += "Game " + scores[i][0] + ": " + scores[i][1] + "\n";
        }

        //connects average score of games using calculateAverage method to string result
        result += "Average Score: " + calculateAverage() + "\n\n";
        //returns string result
        return result;
    }
}
