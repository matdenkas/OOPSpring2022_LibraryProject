package GUI;

import AppDriver.ApplicationDriver;
import DataClasses.LibraryActor;
import DataClasses.MediaTypes;
import DataClasses.OnSiteMedia;
import DataClasses.OnlineMedia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEntry {

    private JTextField titleBox;
    private JTextField isbnBox;
    private JTextField llFeild;
    private JComboBox<String> typeCB;
    private JCheckBox isOnlineCheckBox;

    public void addComponentToPane(Container pane, LibraryActor user) {
        //Search Panel
        JPanel addMedia = new JPanel();
        JLabel title = new JLabel("Title:");
        titleBox = new JTextField(30);
        JLabel isbn = new JLabel("ISBN:");
        isbnBox = new JTextField(15);
        JLabel ll = new JLabel("Link/Location:");
        llFeild = new JTextField(15);
        JLabel type = new JLabel("Media Type");

        String[] comboBoxItems = {
                MediaTypes.BOOK.name(),
                MediaTypes.CD.name(),
                MediaTypes.ARTICLE.name(),
                MediaTypes.MICROFILM.name(),
                MediaTypes.MOVIE.name()
        };
        typeCB = new JComboBox<>(comboBoxItems);
        typeCB.setEditable(false);

        isOnlineCheckBox = new JCheckBox("IsOnline");
        isOnlineCheckBox.setBounds(100,100, 50,50);


        addMedia.add(title);
        addMedia.add(titleBox);
        addMedia.add(isbn);
        addMedia.add(isbnBox);
        addMedia.add(ll);
        addMedia.add(llFeild);
        addMedia.add(type);
        addMedia.add(typeCB);
        addMedia.add(isOnlineCheckBox);

        JPanel addButtonPanel = new JPanel();
        JButton addButton = new JButton("Add Entry");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isOnlineCheckBox.isSelected()){
                    ApplicationDriver.getCatalogRefrence().addMedia(
                            new OnlineMedia(
                                    ApplicationDriver.getIdNum(),
                                    isbnBox.getText(),
                                    llFeild.getText(),
                                    MediaTypes.valueOf(typeCB.getSelectedItem().toString()),
                                    titleBox.getText()
                            )
                    );
                }
                else {
                    ApplicationDriver.getCatalogRefrence().addMedia(
                            new OnSiteMedia(
                                    ApplicationDriver.getIdNum(),
                                    isbnBox.getText(),
                                    llFeild.getText(),
                                    MediaTypes.valueOf(typeCB.getSelectedItem().toString()),
                                    titleBox.getText()
                            )
                    );
                }
            }
        });

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
