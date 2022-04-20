package GUI;

import DataClasses.LibraryActor;
import DataClasses.LibraryEmployee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPage implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    final static String MEDIA_CARD = "Library Media";
    final static String USER_INFORMATION = "User Information";

    public void addComponentToPane(Container pane, LibraryActor user) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String[] comboBoxItems = {MEDIA_CARD, USER_INFORMATION };
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        cards = new JPanel(new CardLayout());
        //Create the "cards".
        JPanel card1 = new JPanel();

            JPanel SearchBarPane = new JPanel();
            JTextField searchBar = new JTextField(50);
            searchBar.setText("Enter Title...");
            JButton searchButton = new JButton();
            searchButton.setText("Search");
            JLabel optionsLabel = new JLabel("Search by:");
            /*JRadioButton rb1 = new JRadioButton("Text");
            JRadioButton rb2 = new JRadioButton("ISBN");
            JRadioButton rb3 = new JRadioButton("Media Type");
            ButtonGroup g = new ButtonGroup();
            g.add(rb1);
            g.add(rb2);
            g.add(rb3);*/
            String[] searchOptions = {"BOOK", "CD", "ARTICLE", "MICROFILM", "MOVIE"};
            JComboBox<String> options = new JComboBox<String>(searchOptions);
            SearchBarPane.add(searchBar);
            SearchBarPane.add(searchButton);
            SearchBarPane.add(optionsLabel);
            SearchBarPane.add(options);

            if(user.getClass() == LibraryEmployee.class)
            {
                JButton mediaEntryButton = new JButton("Edit Entries");
                mediaEntryButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Open EditEntries window
                        EditEntries.generateGUI(user);
                    }
                });
                SearchBarPane.add(mediaEntryButton);
            }

            //SearchBarPane.add(rb2);
            //SearchBarPane.add(rb3);
            card1.add(SearchBarPane);
            JPanel resultsPane = new JPanel();

            String[] listContents = {"Placeholder1", "To be populated by media"};

            JList<String> resultList = new JList<>(listContents);
            resultsPane.add(resultList);

            card1.add(resultsPane);

            //Search Button Listener
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
        });
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

        //Integrated with MEDIA CARD
        /*
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
        */


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
