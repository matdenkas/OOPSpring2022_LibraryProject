package GUI;

import AppDriver.ApplicationDriver;
import DataClasses.LibraryActor;
import DataClasses.LibraryClient;
import DataClasses.LibraryEmployee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewUser {

    JTextField name;
    JTextField username;
    JTextField password;
    JTextField address;
    JCheckBox isEmployee;

    public void addComponentToPane(Container pane, LibraryActor user) {
        //Member Add Panel
        JPanel memberAdd = new JPanel();

        JPanel namePanel = new JPanel();
        Label nameLabel = new Label("Name: ");
        name = new JTextField(15);
        namePanel.add(nameLabel);
        namePanel.add(name);
        memberAdd.add(namePanel);

        JPanel usernamePanel = new JPanel();
        Label usernameLabel = new Label("Username: ");
        username = new JTextField(15);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(username);
        memberAdd.add(usernamePanel);

        JPanel passwordPanel = new JPanel();
        Label passwordLabel = new Label("Password: ");
        password = new JTextField(15);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(password);
        memberAdd.add(passwordPanel);

        JPanel addressPanel = new JPanel();
        Label addressLabel = new Label("Address: ");
        address = new JTextField(15);
        addressPanel.add(addressLabel);
        addressPanel.add(address);
        memberAdd.add(passwordPanel);

        isEmployee = new JCheckBox("IsEmployee");
        memberAdd.add(isEmployee);

        JButton addAction = new JButton("Add Client");
        addAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEmployee.isSelected()){
                    ApplicationDriver.getUserAuthHandler().addUser(
                            new LibraryEmployee(
                                ApplicationDriver.getIdNum(),
                                name.getText(),
                                username.getText(),
                                user.getPassword(),
                                address.getText(),
                                7.30
                        )
                    );
                }
                else {
                    ApplicationDriver.getUserAuthHandler().addUser(
                            new LibraryClient(
                                    ApplicationDriver.getIdNum(),
                                    name.getText(),
                                    username.getText(),
                                    user.getPassword(),
                                    address.getText(),
                                    6
                            )
                    );
                }
            }
        });
        memberAdd.add(addAction);
        pane.add(memberAdd, BorderLayout.NORTH);
    }

    public static void generateGUI(LibraryActor user) {
        //Create and set up the window.
        JFrame frame = new JFrame("Member Management");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Create and set up the content pane.
        AddNewUser window = new AddNewUser();
        window.addComponentToPane(frame.getContentPane(), user);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
