import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissors extends JFrame implements ActionListener{
    JButton rockbutton, paperbutton, scissorbutton;
    JLabel computerchoice;
    Rockpaperscissorbackend rockpaperscissorbackend;
    JLabel computerscore, playerscore;

    public RockPaperScissors() {
        super("Rock Paper Scissors");

        setSize(450, 574);
        setLayout(null);
        setLocationRelativeTo(null);

        rockpaperscissorbackend = new Rockpaperscissorbackend();
        addGuiComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    private void addGuiComponents() {
         computerscore = new JLabel("Computer: 0");
        computerscore.setBounds(0, 43, 450, 30);
        computerscore.setFont(new Font("Dialog", Font.BOLD, 26));
        add(computerscore);
        computerscore.setHorizontalAlignment(SwingConstants.CENTER);

        computerchoice = new JLabel(("?"));
        computerchoice.setBounds(175, 118, 98, 81);
        computerchoice.setFont(new Font("Dialog", Font.BOLD, 18));
        computerchoice.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerchoice);
        computerchoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        playerscore = new JLabel("Player: 0");
        playerscore.setBounds(0, 317, 450, 30);
        playerscore.setFont(new Font("Dialog", Font.BOLD, 26));
        playerscore.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerscore);

        rockbutton = new JButton("Rock");
        rockbutton.setBounds(40, 387, 105, 81);
        rockbutton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockbutton.addActionListener(this);
        add(rockbutton);

        paperbutton = new JButton("Paper");
        paperbutton.setBounds(165, 387, 105, 81);
        paperbutton.setFont(new Font("Dialog", Font.PLAIN, 18));
        paperbutton.addActionListener(this);
        add(paperbutton);

        scissorbutton = new JButton("Scissor");
        scissorbutton.setBounds(290, 387, 105, 81);
        scissorbutton.setFont(new Font("Dialog", Font.PLAIN, 18));
        scissorbutton.addActionListener(this);
        add(scissorbutton);



    }

    private void showdialog(String message) {
        JDialog resultdiaglog = new JDialog(this, "Result", true);
        resultdiaglog.setSize(227, 124);
        resultdiaglog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultdiaglog.setResizable(false);
        resultdiaglog.setLayout(new BorderLayout());

        JLabel resultlabel = new JLabel(message);
        resultlabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultlabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultdiaglog.add(resultlabel, BorderLayout.CENTER); // ✅ Only once, with position

        JButton tryagain = new JButton("Try Again");
        tryagain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computerchoice.setText("?"); // make sure computerchoice is not null!
                resultdiaglog.dispose();
            }
        });
        resultdiaglog.add(tryagain, BorderLayout.SOUTH); // ✅ Button at bottom

        resultdiaglog.setLocationRelativeTo(this); // Center on parent window
        resultdiaglog.setVisible(true); // Show dialog
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String playerchoice = e.getActionCommand().toString();
       String result = rockpaperscissorbackend.playrockpaperscissors(playerchoice);
       computerchoice.setText(rockpaperscissorbackend.getComputerchoice());
        computerscore.setText("Computer:" + rockpaperscissorbackend.getComputerscore());
        playerscore.setText("Player: "+rockpaperscissorbackend.getPlayerscore());
        showdialog(result);
    }
}
