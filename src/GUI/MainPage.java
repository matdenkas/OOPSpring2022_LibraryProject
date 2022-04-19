package GUI;

import DataClasses.LibraryActor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPage implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    final static String MEDIA_CARD = "Media Card";
    final static String USER_INFORMATION = "User Information";
    final static String LIBRARY_MANAGEMENT = "Library Media";

    public void addComponentToPane(Container pane, LibraryActor user) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String[] comboBoxItems = {MEDIA_CARD, USER_INFORMATION, LIBRARY_MANAGEMENT };
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        cards = new JPanel(new CardLayout());
        //Create the "cards".
        JPanel card1 = new JPanel();
            TextField c1_t1 = new TextField();
            c1_t1.setText("PLACEHOLDER");
            c1_t1.setEditable(false);
            card1.add(c1_t1);
        cards.add(card1, MEDIA_CARD);

        JPanel card2 = new JPanel();
            TextField c2_t1 = new TextField();
            c2_t1.setText("Name: " + user.getName());
            c2_t1.setEditable(false);
            card2.add(c2_t1);

            TextField c2_t2 = new TextField();
            c2_t2.setText("Username: " + user.getUsername());
            c2_t2.setEditable(false);
            card2.add(c2_t2);

            TextField c3_t3 = new TextField();
            c3_t3.setText("Name: " + user.getPassword());
            c3_t3.setEditable(false);
            card2.add(c3_t3);
        cards.add(card2, USER_INFORMATION);

        JPanel card3 = new JPanel();
            Button c3_b1 = new Button();
            c3_b1.setLabel("Check Out Media");
            card3.add(c3_b1);
            c3_b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        CheckoutPage.createAndShowGUI(user);
                }
            });
        cards.add(card3, LIBRARY_MANAGEMENT);


        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }


    public static void createAndShowGUI(LibraryActor user) {
        //Create and set up the window.
        JFrame frame = new JFrame("Main Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MainPage demo = new MainPage();
        demo.addComponentToPane(frame.getContentPane(), user);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
