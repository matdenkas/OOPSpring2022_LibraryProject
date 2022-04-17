package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import AppDriver.ApplicationDriver;
import DataClasses.LibraryActor;
import DataClasses.LibraryEmployee;
import DataControlers.UserAuthHandler;

public class LoginPage extends JFrame {

    private UserAuthHandler userAuthHandler;

    private JPanel userPanel;
        private JTextField userInput_header;
        private JTextField userInput;

    private  JPanel passPanel;
        private JTextField passInput_header;
        private JTextField passInput;

    private JButton loginButton;

    public LoginPage(UserAuthHandler uah) {
        super("Login Page");

        userAuthHandler = uah;

        //this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
        this.getContentPane().setBackground(Color.GRAY);
        Dimension fieldSize = new Dimension(200, 100);
        this.setSize(fieldSize);
        this.setLayout(new GridLayout(3, 1, 0, 2));

        userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(1, 2));
        userPanel.setBackground(Color.CYAN);
        userPanel.setSize(fieldSize);
    //userPanel Component construction!

        userInput_header = new JTextField(20);
        userInput_header.setBackground(Color.CYAN);
        userInput_header.setEditable(false);
        userInput_header.setText("Username: ");
        userPanel.add(userInput_header);

        userInput = new JTextField(20);
        userInput.setBackground(Color.WHITE);
        userPanel.add(userInput);
    //END

        passPanel = new JPanel();
        passPanel.setLayout(new GridLayout(1, 2));
        passPanel.setBackground(Color.CYAN);
        passPanel.setSize(fieldSize);

    //passPanel Component construction
        passInput_header = new JTextField(20);
        passInput_header.setBackground(Color.CYAN);
        passInput_header.setEditable(false);
        passInput_header.setText("Password: ");
        passPanel.add(passInput_header);

        passInput = new JTextField(20);
        passInput.setBackground(Color.WHITE);
        passPanel.add(passInput);

    //END
        this.add(userPanel);
        this.add(passPanel);

        BtnHandler btnHandler = new BtnHandler();
        loginButton = new JButton("Login");
        loginButton.addActionListener(btnHandler);
        this.add(loginButton);
    }

    private class BtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Clear" -> login();
            }
        }
    }

    private void  login() {
        ApplicationDriver.authTest(userInput.getText(), passInput.getText());
    }

}
