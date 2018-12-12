package inter;

import backend.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* This class represents the login.
*/
public class Login {
    /**
    * @param loginPanel panel to login.
    */
    private JPanel loginPanel;
    /**
    * @param username username.
    */
    private JTextField username;
    /**
    * @param password password.
    */
    private JPasswordField password;
    /**
    * @param login login.
    */
    private JButton login;
    /**
    * @param notLogin notLogin.
    */
    private JButton notLogin;

    public Login(JFrame frame, Difficulty difficulty,TypeMystery typeMystery) {

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pswdArray = password.getPassword();
                String str = "";
                for(char c : pswdArray) str+=String.valueOf(c);
                new Riddle(frame, difficulty, typeMystery, username.getText(), str).Initialize();
            }
        });
        notLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Riddle(frame, difficulty, typeMystery, "", "").Initialize();
            }
        });
    }
    public JPanel GetLogin() { return loginPanel; }

}
