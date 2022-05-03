package DataControlers;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import DataClasses.*;

import javax.swing.*;

public class MediaCatalogHandler implements CatalogRefrence {

    private HashMap<String, MediaEntry> mediaEntries;
    private ArrayList<String> titleList;

    public MediaCatalogHandler() {
        mediaEntries = new HashMap<>();
        titleList = new ArrayList<>();
    }

    private JPanel createMediaEntryPanel(MediaEntry entry) {
        JPanel panel = new JPanel();

        TextField nameHeader = new TextField(15);
        nameHeader.setEditable(false);
        nameHeader.setText("Name: " + entry.getName());
        panel.add(nameHeader);

        TextField isbnHeader = new TextField(5);
        isbnHeader.setEditable(false);
        isbnHeader.setText("ISBN: " + entry.getIsbn());
        panel.add(isbnHeader);

        TextField isAvailable = new TextField(5);
        isAvailable.setEditable(false);
        isAvailable.setText("Available: " + (entry.isAvailable() ? "True" : "False"));
        panel.add(isAvailable);

        if(entry instanceof OnlineMedia){
            TextField linkHeader = new TextField(10);
            linkHeader.setEditable(false);
            linkHeader.setText("Link: " + ((OnlineMedia) entry).getLink());
            panel.add(linkHeader);

            TextField typeHeader = new TextField(5);
            typeHeader.setEditable(false);
            typeHeader.setText("Type: " + ((OnlineMedia) entry).getType());
            panel.add(typeHeader);
        }
        else {
            TextField locationHeader = new TextField(10);
            locationHeader.setEditable(false);
            locationHeader.setText("Location: " + ((OnSiteMedia) entry).getLocation());
            panel.add(locationHeader);

            TextField typeHeader = new TextField(5);
            typeHeader.setEditable(false);
            typeHeader.setText("Type: " + ((OnSiteMedia) entry).getType());
            panel.add(typeHeader);
        }

        return panel;
    }

    @Override
    public JPanel[] getAllMediaItems() {
        JPanel[] panels = new JPanel[titleList.size()];
        for(int i = 0; i < titleList.size(); i++) {
            panels[i] = createMediaEntryPanel(mediaEntries.get(titleList.get(i)));
        }
        return  panels;
    }

    @Override
    public JPanel medeaItemSearch(String title) {
        MediaEntry entry = mediaEntries.get(title);
        if(entry != null) {
            return createMediaEntryPanel(entry);
        }
        else return null;
    }

    @Override
    public void addMedia(MediaEntry newMedia) {
        String title = newMedia.getName();
        if(mediaEntries.get(title) == null){ //is not in the map
            mediaEntries.put(title, newMedia);
            titleList.add(title);
        }
    }

    @Override
    public void deleteItemByTitle(String title){
        titleList.remove(title);
        mediaEntries.remove(title);
    }
}
