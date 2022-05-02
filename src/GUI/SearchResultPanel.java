package GUI;

import javax.swing.*;
import java.awt.*;

public class SearchResultPanel {
    public SearchResultPanel(JPanel panel) {
        JFrame frame = new JFrame("SearchResult");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if(panel != null){
            frame.add(panel);
        }
        else {
            JTextField text = new JTextField();
            text.setText("Search not found");
            text.setEditable(false);
            text.setForeground(Color.RED);
            frame.add(text);
        }


        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
