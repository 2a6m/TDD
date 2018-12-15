package inter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import backend.*;

/**
* This class represents the app.
*/
public class App {
    /**
    * @param interfaceMain interface for the main part.
    */
    private JPanel interfaceMain;
    /**
    * @param title title.
    */
    private JLabel title;
    /**
    * @param intro introduction.
    */
    private JLabel intro;
    /**
    * @param difficulty difficulty.
    */
    private JComboBox difficulty;
    /**
    * @param validateButton button to validate.
    */
    private JButton validateButton;
    /**
     * Constructor.
     *
     * @param frame window of the game.
     */
    public App(JFrame frame) {
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Difficulty difficultyObject;

                switch (difficulty.getSelectedItem().toString()) {
                    case "Facile":
                        difficultyObject = new Difficulty("easy");
                        frame.setContentPane(new GameChoice(frame, difficultyObject).GetGameChoice());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        break;
                    case "Moyen":
                        difficultyObject = new Difficulty("intermediate");
                        frame.setContentPane(new GameChoice(frame, difficultyObject).GetGameChoice());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        break;
                    case "Difficile":
                        difficultyObject = new Difficulty("advanced");
                        frame.setContentPane(new GameChoice(frame, difficultyObject).GetGameChoice());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        break;
                    default:
                        System.out.println("Invalid difficulty chosen.");
                        break;
                }
            }
        });
    }

    /**
     * method main.
     *
     * @param args arguments received at the launch
     */
    @SuppressWarnings("checkstyle:methodname")
    public static void main(String[] args) {
        JFrame frame = new JFrame("MysteryGame");
        frame.setContentPane(new App(frame).interfaceMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
