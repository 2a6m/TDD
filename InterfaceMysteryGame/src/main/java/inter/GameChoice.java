package inter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import backend.*;

/**
* This class represents the game choice.
*/
public class GameChoice {
    /**
    * @param gameChoice choice of the game.
    */
    private JPanel gameChoice;
    /**
    * @param title title.
    */
    private JLabel title;
    /**
    * @param intro introduction.
    */
    private JLabel intro;
    /**
    * @param gameMode mode of the game.
    */
    private JComboBox gameMode;
    /**
    * @param playButton button to play.
    */
    private JButton playButton;

    /**
     * Constructor.
     *
     * @param frame window.
     * @param difficulty difficulty.
     */
    public GameChoice(JFrame frame, Difficulty difficulty) {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, gameMode.getSelectedItem());
                switch (gameMode.getSelectedItem().toString()) {
                    case "Devinette":
                        SentenceMystery typeMystery = new SentenceMystery();
                        frame.setContentPane(new Login(frame, difficulty, typeMystery).GetLogin());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        break;
                    default:
                        System.out.println("Invalid game mode chosen.");
                        break;
                }
            }
        });
    }

    /**
     * getter.
     *
     * @return user's game choice
     */
    public JPanel GetGameChoice() {
        return gameChoice;
    }
}
