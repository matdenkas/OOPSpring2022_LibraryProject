package GUI;


import DataClasses.LibraryActor;
import DataClasses.LibraryEmployee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditEntries {

    public void addComponentToPane(Container pane, LibraryActor user) {
        //Search Panel
        JPanel mediaSearchPane = new JPanel();
        JTextField searchBox = new JTextField(50);
        searchBox.setText("Enter Title");
        JButton executeSearch = new JButton("Search");
        JButton addEntryButton = new JButton("Add Media Entry...");
        executeSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Search method call
            }
        });
        addEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add Entry Wizard Call
            }
        });
        mediaSearchPane.add(searchBox);
        mediaSearchPane.add(executeSearch);
        mediaSearchPane.add(addEntryButton);

        //Entries List Panel
        JPanel resultsPane = new JPanel();
        JList<String> entriesList = new JList<>();
        resultsPane.add(entriesList);


        //Action Buttons (Edit/Delete)
        pane.add(mediaSearchPane, BorderLayout.NORTH);
        pane.add(resultsPane, BorderLayout.CENTER);
    }

    public static void generateGUI(LibraryActor user) {
        //Create and set up the window.
        JFrame frame = new JFrame("Edit Media Entries");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Create and set up the content pane.
        EditEntries window = new EditEntries();
        window.addComponentToPane(frame.getContentPane(), user);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
