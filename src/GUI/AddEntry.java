package GUI;

import DataClasses.LibraryActor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEntry {

    public void addComponentToPane(Container pane, LibraryActor user) {
        //Search Panel
        JPanel addMedia = new JPanel();
        JLabel title = new JLabel("Title:");
        JTextField titleBox = new JTextField(30);
        JLabel isbn = new JLabel("ISBN:");
        JTextField isbnBox = new JTextField(30);
        JLabel type = new JLabel("Media Type");

        JRadioButton bookOption = new JRadioButton("Book");
        JRadioButton cdOption = new JRadioButton("CD");
        JRadioButton articleOption = new JRadioButton("Article");
        JRadioButton microOption = new JRadioButton("Micro Film");
        JRadioButton movieOption = new JRadioButton("Movie");
        ButtonGroup optionSelect = new ButtonGroup();
        optionSelect.add(bookOption);
        optionSelect.add(cdOption);
        optionSelect.add(articleOption);
        optionSelect.add(microOption);
        optionSelect.add(movieOption);

        addMedia.add(title);
        addMedia.add(titleBox);
        addMedia.add(isbn);
        addMedia.add(isbnBox);
        addMedia.add(type);
        addMedia.add(bookOption);
        addMedia.add(cdOption);
        addMedia.add(articleOption);
        addMedia.add(microOption);
        addMedia.add(movieOption);

        JPanel addButtonPanel = new JPanel();
        JButton addButton = new JButton("Add Entry");

        addButtonPanel.add(addButton);

        pane.add(addMedia, BorderLayout.NORTH);
        pane.add(addButtonPanel, BorderLayout.CENTER);
    }

    public static void generateGUI(LibraryActor user) {
        //Create and set up the window.
        JFrame frame = new JFrame("Add an Entry");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Create and set up the content pane.
        AddEntry window = new AddEntry();
        window.addComponentToPane(frame.getContentPane(), user);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
