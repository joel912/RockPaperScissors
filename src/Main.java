import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
      SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
              RockPaperScissors rockPaperScissors = new RockPaperScissors();

              rockPaperScissors.setVisible(true);

          }
      });
    }
}