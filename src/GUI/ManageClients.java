package GUI;

import DataClasses.LibraryActor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageClients {

    public void addComponentToPane(Container pane, LibraryActor user) {
        //Member Add Panel
        JPanel memberAdd = new JPanel();
        JLabel newMemName = new JLabel("New Member Name:");
        JTextField nameField = new JTextField(30);
        JTextField memberID = new JTextField(30);
        memberID.setText("Member ID");
        JTextField memberPassword = new JTextField(30);
        memberPassword.setText("Member Password");
        JButton confirmButton = new JButton("Add Member");
        memberAdd.add(newMemName);
        memberAdd.add(nameField);
        memberAdd.add(memberID);
        memberAdd.add(memberPassword);
        memberAdd.add(confirmButton);

        //Member Edit Panel
        JPanel editPanel = new JPanel();
        JLabel currentMembers = new JLabel("Current Member List");
        JList<String> memberList = new JList<>();
        JButton deleteMember = new JButton("Delete Member");
        editPanel.add(currentMembers);
        editPanel.add(memberList);
        editPanel.add(deleteMember);


        pane.add(memberAdd, BorderLayout.NORTH);
        pane.add(editPanel, BorderLayout.CENTER);
    }

    public static void generateGUI(LibraryActor user) {
        //Create and set up the window.
        JFrame frame = new JFrame("Member Management");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Create and set up the content pane.
        ManageClients window = new ManageClients();
        window.addComponentToPane(frame.getContentPane(), user);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
