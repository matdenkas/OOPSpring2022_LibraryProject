package GUI;

import DataClasses.LibraryActor;
import DataClasses.LibraryEmployee;
import DataControlers.CatalogRefrence;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class MainPage implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    private CatalogRefrence catalogRefrence;
    private LibraryActor user;
    final static String MEDIA_CARD = "Library Media";
    final static String USER_INFORMATION = "User Information";
    private JTextField executeSearch;
    private JFrame saveFrame;
    private JPanel resultsPane;

    public MainPage(CatalogRefrence catalog, LibraryActor user) {
        this.catalogRefrence = catalog;
        this.user = user;

        //Create and set up the window.
        JFrame frame = new JFrame("Main Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        buildOnFrame(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        saveFrame = frame;
    }

    public void buildOnFrame(Container pane) {
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
            executeSearch = searchBar;
            searchBar.setText("Enter Title...");
            JButton searchButton = new JButton();
            searchButton.setText("Search");
            SearchBarPane.add(searchBar);
            SearchBarPane.add(searchButton);

            if(user.getClass() == LibraryEmployee.class)
            {
                JButton mediaEntryButton = new JButton("Edit Entries");
                mediaEntryButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Open EditEntries window
                        new EditEntries(user);
                    }
                });
                JButton manageClients = new JButton("Manage Clients");
                manageClients.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Open Manage Clients Window
                        ManageClients.generateGUI(user);
                    }
                });
                SearchBarPane.add(mediaEntryButton);
                SearchBarPane.add(manageClients);
            }

            card1.add(SearchBarPane);
            JButton refreshButton = new JButton("Refresh");
            refreshButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveFrame.getContentPane().remove(resultsPane);
                    JPanel[] panels = catalogRefrence.getAllMediaItems();
                    System.out.println(panels.length);
                    JPanel resultsPane = new JPanel();
                    resultsPane.setLayout(new BoxLayout(resultsPane, BoxLayout.PAGE_AXIS));
                    for(JPanel panel : panels){
                        resultsPane.add(panel);
                    }
                    saveFrame.add(resultsPane);
                    saveFrame.revalidate();
                    System.out.println("Beeeep");
                }
            });
            card1.add(refreshButton);
            resultsPane = new JPanel();

            JPanel[] panels = catalogRefrence.getAllMediaItems();
            JPanel resultList = new JPanel();
            resultList.setLayout(new BoxLayout(resultList, BoxLayout.PAGE_AXIS));
            for(JPanel panel : panels){
                resultList.add(panel);
            }
            resultsPane.add(resultList);

            card1.add(resultsPane);

            //Search Button Listener
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (e.getActionCommand()) {
                        case "Search":
                            JPanel panel = catalogRefrence.medeaItemSearch(executeSearch.getText());
                            new SearchResultPanel(panel);
                    }
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
}
