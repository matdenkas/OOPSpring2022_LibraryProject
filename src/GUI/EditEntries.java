package GUI;


import DataClasses.LibraryActor;
import AppDriver.ApplicationDriver;
import DataControlers.CatalogRefrence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static AppDriver.ApplicationDriver.getCatalogRefrence;

public class EditEntries {

    private JTextField searchBox;
    private JPanel selected;
    private JFrame saveFrame;
    private ActionListener buttonHandler;

    public EditEntries(LibraryActor user) {
        //Create and set up the window.
        JFrame frame = new JFrame("Edit Media Entries");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //init button handler
        buttonHandler = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CatalogRefrence cr = getCatalogRefrence();
                switch (e.getActionCommand()) {
                    case "Search":
                        saveFrame.getContentPane().remove(selected);
                        JPanel entryPanel = cr.medeaItemSearch(searchBox.getText());

                        selected = new JPanel();
                        if(entryPanel != null) {
                            selected.add(entryPanel);
                            JButton delete = new JButton("Delete");
                            delete.addActionListener(buttonHandler);
                            selected.add(delete);
                        }
                        else {
                            JTextField text = new JTextField();
                            text.setText("Search not found");
                            text.setEditable(false);
                            text.setForeground(Color.RED);
                            selected.add(text);
                        }
                        saveFrame.add(selected);
                        saveFrame.revalidate();
                        break;
                    case "Add Media Entry...":
                        AddEntry.generateGUI(user);
                        break;
                    case "Delete":
                        cr.deleteItemByTitle(searchBox.getText());
                        break;
                }
            }
        };

        addComponentToPane(frame.getContentPane(), user);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        saveFrame = frame;
    }

    public void addComponentToPane(Container pane, LibraryActor user) {

        //Search Panel
        JPanel mediaSearchPane = new JPanel();
        searchBox = new JTextField(50);
        searchBox.setText("Enter Title");
        JButton executeSearch = new JButton("Search");
        executeSearch.addActionListener(buttonHandler);

        JButton addEntryButton = new JButton("Add Media Entry...");
        addEntryButton.addActionListener(buttonHandler);

        mediaSearchPane.add(searchBox);
        mediaSearchPane.add(executeSearch);
        mediaSearchPane.add(addEntryButton);

        //Action Buttons (Edit/Delete)
        pane.add(mediaSearchPane, BorderLayout.NORTH);
        selected = new JPanel();
        pane.add(selected);
    }
}
