import java.util.Random;

public class Rockpaperscissorbackend {
    private static final String[] computerchoices = {"Rock", "Paper", "Scissors"};
    private Random random;
    private String computerchoice;
    private int computerscore, playerscore;

    public Rockpaperscissorbackend() {
        random = new Random();
    }

    public String getComputerchoice() {
        return computerchoice;
    }

    public int getComputerscore() {
        return computerscore;
    }

    public int getPlayerscore() {
        return playerscore;
    }

    public String playrockpaperscissors(String playerchoice) {
        computerchoice = computerchoices[random.nextInt(computerchoices.length)];
        String result;

        if (computerchoice.equals("Rock")) {
            if (playerchoice.equals("Paper")) {
                result = "Player wins";
                playerscore++;
            } else if (playerchoice.equals("Scissors")) {
                result = "Computer wins";
                computerscore++;
            } else {
                result = "Draw";
            }
        }

        else if (computerchoice.equals("Paper")) {
            if (playerchoice.equals("Scissors")) {
                result = "Player wins";
                playerscore++;
            } else if (playerchoice.equals("Rock")) {
                result = "Computer wins";
                computerscore++;
            } else {
                result = "Draw";
            }
        }

        else { // computerchoice == "Scissors"
            if (playerchoice.equals("Rock")) {
                result = "Player wins";
                playerscore++;
            } else if (playerchoice.equals("Paper")) {
                result = "Computer wins";
                computerscore++;
            } else {
                result = "Draw";
            }
        }

        return result;
    }
}
