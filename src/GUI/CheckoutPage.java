package GUI;

import java.awt.event.ItemListener;

import DataClasses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CheckoutPage {
    private JButton searchButton;
    private JTextField searchBar;
    private JList<String> resultList;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;

    public void pageBuild(Container pane, LibraryActor user){
        JPanel userInfo = new JPanel();
        JLabel info = new JLabel();
        info.setText("Welcome, " + user.getName() + ".");
        userInfo.add(info);

        JPanel SearchBarPane = new JPanel();
        searchBar = new JTextField(50);
        searchBar.setText("Enter Title...");
        searchButton = new JButton();
        searchButton.setText("Search");
        JLabel optionsLabel = new JLabel("Search by:");
        rb1 = new JRadioButton("Text");
        rb2 = new JRadioButton("ISBN");
        rb3 = new JRadioButton("Media Type");
        ButtonGroup g = new ButtonGroup();
        g.add(rb1);
        g.add(rb2);
        g.add(rb3);
        SearchBarPane.add(searchBar);
        SearchBarPane.add(searchButton);
        SearchBarPane.add(optionsLabel);
        SearchBarPane.add(rb1);
        SearchBarPane.add(rb2);
        SearchBarPane.add(rb3);
        JPanel resultsPane = new JPanel();
        resultList = new JList();
        resultsPane.add(resultList);

        pane.add(userInfo, BorderLayout.PAGE_START);
        pane.add(SearchBarPane, BorderLayout.CENTER);
        pane.add(resultsPane, BorderLayout.PAGE_END);
    }

    public static void createAndShowGUI(LibraryActor user) {
        //Create and set up the window.
        JFrame frame = new JFrame("Checkout Media Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Content pane
        CheckoutPage view = new CheckoutPage();
        view.pageBuild(frame.getContentPane(), user);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    //search function
    public void searchMedia(String title)
    {

    }
}
